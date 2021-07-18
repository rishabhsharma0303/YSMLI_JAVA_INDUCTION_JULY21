package com.customerapp.controller;
import java.util.*;

import com.customerapp.customer.Customer;
import com.customerapp.customer.CustomerDao;
import com.customerapp.customer.CustomerDaoImpl;

public class Main {

	public static void main(String[] args) {
		CustomerDao customerDao=new CustomerDaoImpl();
//		List<Customer> customers=customerDao.allCustomers();
//		customers.forEach(c-> System.out.println(c));
		
		// find by id
		
//		Customer customer=customerDao.getCustomerById(60);
//		System.out.println(customer);
		
		//add new customer
		
//		Customer customer=new Customer("puneet", "noida", "45454545", "p@gmail.com", new Date());
//		customerDao.addCustomer(customer);
//		System.out.println("customer is added.....");
		
//		Customer customer=customerDao.getCustomerById(6);
//		customer.setAddress("chennai");
//		customerDao.updateCustomer(6, customer);
//		System.out.println("customer is update.....");
		
		//delete the record
		
		customerDao.deleteCustomer(7);
		System.out.println("deleted...");
	}

}
