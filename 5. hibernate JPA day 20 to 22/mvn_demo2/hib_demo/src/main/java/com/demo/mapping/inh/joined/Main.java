package com.demo.mapping.inh.joined;

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
		
//		Account account=new SavingAccount("raj", 1000, 4.5);
//		Account account2=new CurrentAccount("gun", 2000, 2000);
//		
//		session.save(account2);
//		session.save(account);
		
		session.getTransaction().commit();

		session.close();
		factory.close();

	}
}
