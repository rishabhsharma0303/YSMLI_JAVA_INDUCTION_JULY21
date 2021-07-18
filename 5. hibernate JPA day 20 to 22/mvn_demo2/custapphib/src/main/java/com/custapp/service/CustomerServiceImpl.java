package com.custapp.service;

import java.util.List;

import org.hibernate.SessionFactory;

import com.custapp.dao.customer.Customer;
import com.custapp.dao.customer.CustomerDao;
import com.custapp.dao.customer.CustomerDaoImpl;

public class CustomerServiceImpl implements CustomerService {

	private CustomerDao customerDao;
	

	public CustomerServiceImpl(SessionFactory factory) {
		customerDao=new CustomerDaoImpl(factory);
	}

	@Override
	public List<Customer> allCustomers() {
		return customerDao.allCustomers();
	}

	@Override
	public Customer addCustomer(Customer customer) {
		return customerDao.addCustomer(customer);
	}

	@Override
	public void deleteCustomer(int id) {
		customerDao.deleteCustomer(id);
	}

	@Override
	public void updateCustomer(int id, Customer customer) {
		customerDao.updateCustomer(id, customer);
	}

	@Override
	public Customer getCustomerById(int id) {
		return customerDao.getCustomerById(id);
	}

}
