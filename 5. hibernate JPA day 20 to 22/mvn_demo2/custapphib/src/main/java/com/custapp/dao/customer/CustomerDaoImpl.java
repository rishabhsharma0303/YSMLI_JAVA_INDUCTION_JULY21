package com.custapp.dao.customer;

import java.util.*;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.custapp.dao.HibernateSessionFactory;
import com.custapp.exceptions.CustomerNotFoundException;
import com.custapp.exceptions.DataAccessException;

public class CustomerDaoImpl implements CustomerDao {

	private SessionFactory factory;

	public CustomerDaoImpl(SessionFactory factory) {
		this.factory = factory;
	}

	@Override
	public List<Customer> allCustomers() {

		Session session = factory.openSession();
		List<Customer> customers = session.createQuery("select c from Customer c").getResultList();
		session.close();
		return customers;
	}

	@Override
	public Customer addCustomer(Customer customer) {
		Session session = factory.openSession();
		Transaction tx = session.getTransaction();

		try {
			tx.begin();

			session.save(customer);

			tx.commit();

		} catch (HibernateException ex) {
			tx.rollback();
			throw new DataAccessException(ex.getMessage());
		}finally {
			if(session!=null)
			session.close();
		}
		return customer;
	}

	@Override
	public void deleteCustomer(int id) {
		Session session = factory.openSession();
		Transaction tx = session.getTransaction();

		try {
			tx.begin();

			Customer customer = getCustomerById(id);
			session.delete(customer);
			
			tx.commit();

		} catch (HibernateException ex) {
			tx.rollback();
			throw new DataAccessException(ex.getMessage());
		}finally {
			if(session!=null)
			session.close();
		}

	}

	@Override
	public void updateCustomer(int id, Customer customer) {
		Session session = factory.openSession();
		Transaction tx = session.getTransaction();

		try {
			tx.begin();

			Customer toBeUpdated=getCustomerById(id);
			toBeUpdated.setAddress(customer.getAddress());
			toBeUpdated.setEmail(customer.getEmail());
			toBeUpdated.setMobile(customer.getMobile());
		
			session.update(toBeUpdated);// what is the diff bw update and merge
			
			tx.commit();

		} catch (HibernateException ex) {
			tx.rollback();
			throw new DataAccessException(ex.getMessage());
			
		}finally {
			if(session!=null)
			session.close();
		}

	}

	@Override
	public Customer getCustomerById(int id) {
		Session session = factory.openSession();
		Customer customer=session.get(Customer.class, id);
		if(customer==null)
			throw new CustomerNotFoundException("customer with id "+ id +" is not found");
		
		session.close();
		
		return customer;
	}

}
