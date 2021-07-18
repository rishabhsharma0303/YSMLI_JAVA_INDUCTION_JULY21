package com.demo.ann;

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
		Session session=factory.openSession(); //openSession vs getCurrentSession
		
		Transaction tx=session.getTransaction();
		Customer customer=new Customer("pooja", "delhi", "4546564554", "ravi@gmail.com", new Date());
		//Review review=new Review("ekta", "good product");
		try {
			tx.begin();
			//session.save(customer);
			System.out.println("--------------------");
			//session.save(review);
			try {
				Thread.sleep(1000);
			}catch(Exception e) {
				e.printStackTrace();
			}
			tx.commit();
			System.out.println("%%%%%%%%%%%%%%%%%%%%%");
		}catch(HibernateException ex) {
			ex.printStackTrace();
			tx.rollback();
		}
		
		factory.close();
	}
}
