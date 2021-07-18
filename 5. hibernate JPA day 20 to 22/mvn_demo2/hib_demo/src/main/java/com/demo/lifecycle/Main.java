package com.demo.lifecycle;

import java.util.Date;

import org.hibernate.HibernateError;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.customerapp.customer.HibernateSessionFactory;

public class Main {

	public static void main(String[] args) {
		SessionFactory factory=HibernateSessionFactory.getSessionFactory();
		
		// how flush() works frm ram---> db
		
		Session session=factory.openSession(); 
		Customer customer=session.get(Customer.class, 1);
	
		System.out.println(customer);
		
		
		session.getTransaction().begin();
		customer.setAddress("chenani");
		customer.setEmail("acb@gmail.com");
		
		
		session.update(customer);
		//session.flush();
		System.out.println("--------------------");
		session.getTransaction().commit();
		System.out.println("-%%%%%%%%%%%%%%%%%%%%%");
		session.close();
		
		factory.close();
		
		
		
		//how session.refresh() works?
//		Session session=factory.openSession(); 
//		Customer customer=session.get(Customer.class, 1);
//	
//		System.out.println(customer);
//		
//		try {
//			Thread.sleep(20000);
//		}catch(InterruptedException ex) {
//			ex.printStackTrace();
//		}
//		session.refresh(customer);
//		System.out.println("--------after refresh-------------");
//		System.out.println(customer);
//		
		
		//update vs merge
		
		//i will create a session and get a object in that session with id=2
		//then close that session
//		Session session=factory.openSession(); 
//		Customer customer=session.get(Customer.class, 1);
//		session.close();
//		//customer is detached :
//		
//		customer.setAddress("noida");
//		customer.setEmail("pp_new@gmail.com");
//		
//		//i will craete a new session
//		// load the same customer with id=2
//		Session session2=factory.openSession(); 
//		session2.getTransaction().begin();
//		
//		Customer customer2=session2.get(Customer.class, 1);
//		customer2.setEmail("pp@gmail.com");
//		session2.merge(customer);
//		
//		session2.getTransaction().commit();
//		//NonUniqueObjectException
//		session2.close();
//		//then i will try to update the customer which was detached of previous session
//		
		// error
		
		
		
		
		// i will come back with diff bw persist() vs save()
		// one return auto gen id while return type of another is void
		
		//Session session=factory.openSession(); 
		
		//Transaction tx=session.getTransaction();
		//Customer customer=new Customer("mm", "banglore", "4546564554", "om@gmail.com", new Date());
		//save() 		vs 		persist()
		
		
		// session.persist(c); // it many not hit db imm as u dont need pk auto
		//session.flush();
		
		
//		try {
//			tx.begin();
//			session.persist(customer);// save() vs persist() --JPA
//			System.out.println("------------");
//			tx.commit();
//		}catch(HibernateException ex) {
//			ex.printStackTrace();
//			tx.rollback();
//		}
//		factory.close();
//		
		
		
		
		
		
		
		
//				get vs load		
		
//		// in case of load hib dont hit the db immediatly ... it give u a proxy (aka fake object)
//		
//		//lazy approach
//		Customer customer=session.get(Customer.class,1);
//		System.out.println("-------------------------------");
//		
//		session.close();
//		//in this case hibernate give u LazyInitEx... becuase u have a proxy object 
//		// no live session is attached with that object now i am trying to getsome data from it
//		// but it is a proxy object(aka fake object) thats why hib throws that ex
//		System.out.println(customer.getName());
//		//System.out.println(customer.getAddress());
		
		
		
		
		
		
		
		
		
		
		
		//Transaction tx=session.getTransaction();
		//Customer customer=new Customer("raj", "delhi", "4546564554", "ravi@gmail.com", new Date());
//		
//		try {
//			tx.begin();
//			session.save(customer);
//			tx.commit();
//		}catch(HibernateException ex) {
//			ex.printStackTrace();
//			tx.rollback();
//		}
		
	}
}
