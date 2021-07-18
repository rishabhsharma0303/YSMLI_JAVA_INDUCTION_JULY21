package com.demo.mapping.inh.joined2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import java.util.*;
import com.customerapp.customer.HibernateSessionFactory;

public class Main {

	public static void main(String[] args) {
		SessionFactory factory = HibernateSessionFactory.getSessionFactory();

		Session session = factory.openSession();

		session.getTransaction().begin();
		
		List<Account> accounts=session.createQuery("from Account").getResultList();
		for(Account account: accounts) {
			System.out.println(account);
		}
//		
		
//		Account account=new PoorSavingAccount("foo", 1000, 5.9, 1000);
//		Account account1=new PoorSavingAccount("bar", 1000, 5.9, 1000);
//		
//		
//		session.persist(account);	
//		session.persist(account1);
		session.getTransaction().commit();

		session.close();
		factory.close();

	}
}
