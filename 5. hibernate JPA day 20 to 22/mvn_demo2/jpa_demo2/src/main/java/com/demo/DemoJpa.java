package com.demo;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class DemoJpa {

	public static void main(String[] args) {
		// SessionFactory ---- EntityMangagerFactory
		// Persistance unit
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.yms.pu");

		// Session ---------- EntityManager
		EntityManager em = emf.createEntityManager();

		EntityTransaction tx = em.getTransaction();
		
		
		try {
			tx.begin();
			//Address add=new Address("A12", "no 12", "no 13", "delhi", "KN", "110051");
			Address address=em.find(Address.class, 	1L);
			System.out.println(address);
			//em.persist(add);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}

		em.close();
		emf.close();

	}
}
