package com.demo;

import java.util.*;

public class CustomerDaoImpl implements CustomerDao {

	private Map<Integer, Customer> map = new HashMap<>();

	public CustomerDaoImpl() {
		map.put(1, new Customer(1, "raj"));
		map.put(2, new Customer(2, "ekta"));
		map.put(3, new Customer(3, "gun"));

	}

	@Override
	public Customer findCustomerById(int id) {
		try {
			Thread.sleep(1000);
		}catch (Exception e) {
		}
		Customer customer=map.get(id);
		if(customer==null)
			throw new CustomerNotFoundEx("cust with id "+ id +" is not found");
			
		return customer;
	}

}
