package com.demo.mapping.many2many.bi;

import java.util.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.customerapp.customer.HibernateSessionFactory;

public class Main {

	public static void main(String[] args) {
		SessionFactory factory = HibernateSessionFactory.getSessionFactory();

		Session session = factory.openSession();

		session.getTransaction().begin();

		session.getTransaction().commit();

		session.close();
		factory.close();

	}
}
