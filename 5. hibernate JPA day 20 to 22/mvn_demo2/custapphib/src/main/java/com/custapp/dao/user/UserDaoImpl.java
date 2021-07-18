package com.custapp.dao.user;

import java.util.*;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.custapp.dao.HibernateSessionFactory;
import com.custapp.exceptions.DataAccessException;

public class UserDaoImpl implements UserDao {

	private SessionFactory factory;

	public UserDaoImpl(SessionFactory factory) {
		this.factory=factory;
	}

	@Override
	public void addUser(User user) {
		Session session = factory.openSession();
		Transaction tx = session.getTransaction();

		try {
			tx.begin();

			session.save(user);

			tx.commit();
		} catch (HibernateException ex) {
			tx.rollback();
			throw new DataAccessException(ex.getMessage());

		} finally {
			session.close();
		}
	}

	@Override
	public User getUser(String username, String password) {
		Session session = factory.openSession();
		List<User> users = session
				.createQuery("select u from User u where u.username=:username and u.password=:password")
				.setParameter("username", username)
				.setParameter("password", password)
				.getResultList();

		if (users.size() > 0)
			return users.get(0);
		else
			throw new UserNotFoundException("user not found");
	}

}
