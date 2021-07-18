package com.customerapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customerapp.dao.Customer;
import com.customerapp.dao.CustomerDao;
import com.customerapp.exceptions.CustomerNotFoundException;
@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao customerDao;
	
	@Override
	public List<Customer> getAll() {
		return customerDao.findAll();
	}

	@Override
	public Customer addCustomer(Customer customer) {
		customerDao.save(customer);
		return customer;
	}

	@Override
	public Customer deleteCustomer(String customerId) {
		Customer customerToDelete=getCustomerById(customerId);
		customerDao.delete(customerToDelete);
		return customerToDelete;
	}

	@Override
	public Customer updateCustomer(String customerId, Customer customer) {
		Customer customerToUpdate=getCustomerById(customerId);
		customerToUpdate.setEmail(customer.getEmail());
		customerToUpdate.setPhone(customer.getPhone());
		customerToUpdate.setAddress(customer.getAddress());
		customerDao.save(customerToUpdate);
		return customerToUpdate;
	}

	@Override
	public Customer getCustomerById(String customerId) {
		return customerDao.findById(customerId)
				.orElseThrow(()-> new CustomerNotFoundException("customer is not found"));
	}

}









