package com.demo.mapping.one2many.uni;
import java.util.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.customerapp.customer.HibernateSessionFactory;

public class Main {

	public static void main(String[] args) {
		SessionFactory factory = HibernateSessionFactory.getSessionFactory();

		Session session = factory.openSession();
		
		session.getTransaction().begin();
		
		//N+1 problem : one query for getting all dept and then one query each for getting emp of each dept
		// 1+ 3
		//from Department d join fetch d.employees Employee
		List<Department> departments=session
				.createQuery("select d from Department d").getResultList();
		
		for(Department department: departments) {
			System.out.println(department);
			List<Employee> employees=department.getEmployees();
			for(Employee employee: employees) {
				System.out.println(employee);
			}
		}
		
		
//		Department department1=new Department("12A", "sales", "amit");
//		Department department2=new Department("1MA", "it", "amit");
//		Department department3=new Department("QA", "mkt", "amit");
//		
//		
//		Employee employee1=new Employee("raja");
//		Employee employee2=new Employee("amit");
//		Employee employee3=new Employee("sumit");
//		Employee employee4=new Employee("ekta");
//
//		Employee employee5=new Employee("keshav");
//		Employee employee6=new Employee("gunika");
//		Employee employee7=new Employee("rajiv");
//		
//		department1.getEmployees().add(employee1);
//		department1.getEmployees().add(employee2);
//		
//		department2.getEmployees().add(employee3);
//		department2.getEmployees().add(employee4);
//		
//		department3.getEmployees().add(employee5);
//		department3.getEmployees().add(employee6);
//		department3.getEmployees().add(employee7);
//		
//	
//		session.save(department1);
//		session.save(department2);
//		session.save(department3);
//		
		/*
		 * session.save(employee1); session.save(employee2); session.save(employee3);
		 * session.save(employee4); session.save(employee5); session.save(employee6);
		 * session.save(employee7);
		 */
		
		session.getTransaction().commit();
		
		session.close();
		factory.close();
	}
}
