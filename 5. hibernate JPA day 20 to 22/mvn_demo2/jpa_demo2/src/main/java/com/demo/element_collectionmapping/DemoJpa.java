package com.demo.element_collectionmapping;

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

		EntityManager em=emf.createEntityManager();
		
		em.getTransaction().begin();
		
		Author author=new Author();
		author.setName("rajesh");
		author.addEmail("ra@gmail.com");
		author.addEmail("ra1@gmail.com");
		author.addEmail("ra2@gmail.com");
		
		
		author.addPhone("64545454554");
		author.addPhone("64005454554");
		author.addPhone("54545454554");
		
		em.persist(author);
		
		em.getTransaction().commit();
		emf.close();

	}
}
