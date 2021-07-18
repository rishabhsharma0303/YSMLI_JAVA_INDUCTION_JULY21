package com.demo.mapping.one2one.uni;
import java.util.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.customerapp.customer.HibernateSessionFactory;

public class Main {

	public static void main(String[] args) {
		SessionFactory factory = HibernateSessionFactory.getSessionFactory();

		Session session = factory.openSession();
		
		//fetch join
		
		List<Parking> parkings=session.createQuery("from Parking p join fetch p.employee Employee").getResultList();
		System.out.println("-------------------");
		for(Parking parking: parkings) {
			System.out.println(parking);
			System.out.println("********************");
			System.out.println(parking.getEmployee());
		}
		
		//Parking parking=session.get(Parking.class, 2);
		
		//System.out.println(parking);
	
		//System.out.println(parking.getEmployee());
		
		session.close();
		factory.close();

//		
//		Employee employee1=new Employee("raj");
//		Employee employee2=new Employee("ekta");
//		Employee employee3=new Employee("gun");
//		Employee employee4=new Employee("keshav");
//		Employee employee5=new Employee("vikas");
//		
//		Parking parking1=new Parking("A12");
//		Parking parking2=new Parking("M2");
//		Parking parking3=new Parking("B2");
//		Parking parking4=new Parking("T11");
//		Parking parking5=new Parking("U12");
//		
//		
//		parking1.setEmployee(employee1);
//		parking2.setEmployee(employee2);
//		parking3.setEmployee(employee3);
//		parking4.setEmployee(employee4);
//		parking5.setEmployee(employee5);
//		
//		Session session=factory.openSession();
//		
//		session.getTransaction().begin();
//		
//		session.persist(parking1);
//		session.persist(parking2);
//		session.persist(parking3);
//		session.persist(parking4);
//		session.persist(parking5);
//		

//
//		session.persist(employee1);
//		session.persist(employee2);
//		session.persist(employee3);
//		session.persist(employee4);
//		session.persist(employee5);
//	

		// session.getTransaction().commit();

	}
}
