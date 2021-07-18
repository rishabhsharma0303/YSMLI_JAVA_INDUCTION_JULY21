package com.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.customerapp.customer.HibernateSessionFactory;

public class GetById {

	public static void main(String[] args) {
		SessionFactory factory=HibernateSessionFactory.getSessionFactory();
		
		Session session=factory.openSession();
		Customer customer=session.get(Customer.class, 5);
		
		//batch processing hib
		//session.evict(customer);// hey hibernate if u have this object with id =5 in the cached pl remote it
		
		Customer customer2=session.get(Customer.class, 5);
		session.close();
		
//		
//		Session session2=factory.openSession();
//		Customer customer2=session2.get(Customer.class, 5);
//		System.out.println(customer2);
//
//		session2.close();
		
		factory.close();
		
		
	}
}
