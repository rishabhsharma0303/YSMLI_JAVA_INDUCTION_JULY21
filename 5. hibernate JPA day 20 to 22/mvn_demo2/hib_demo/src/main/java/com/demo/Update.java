package com.demo;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.customerapp.customer.HibernateSessionFactory;

public class Update {

	public static void main(String[] args) {
		//first get hold of SF---> Session ->start the tx
		
		SessionFactory factory=HibernateSessionFactory.getSessionFactory();
		
		Session session=factory.openSession();
		
		Transaction tx=session.getTransaction();
		
		try {
			tx.begin();
			
			Customer customer=session.get(Customer.class, 3);
			
			customer.setAddress("ny");
			
			session.update(customer);
			
			tx.commit();
			System.out.println("cust is  updated...");
			
		}catch(HibernateException ex) {
			tx.rollback();
		}
		
	}
}
