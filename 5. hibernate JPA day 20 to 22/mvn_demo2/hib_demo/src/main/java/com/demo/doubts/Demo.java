package com.demo.doubts;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.customerapp.customer.HibernateSessionFactory;

public class Demo {

	public static void main(String[] args) {
		//Save vs persist
		// persist must be used : this from JPA spec, ...
		
		SessionFactory factory=HibernateSessionFactory.getSessionFactory();
		
		Session session=factory.openSession();
		Customer customer=session.get(Customer.class, 1);
		session.close();
		
		session=factory.openSession();
		customer.setAddress("ny 6");
		session.getTransaction().begin();
		
		// save vs persist
		
		session.save(customer);
		
		session.getTransaction().commit();
		
		session.close();
		factory.close();
		
	}
}
