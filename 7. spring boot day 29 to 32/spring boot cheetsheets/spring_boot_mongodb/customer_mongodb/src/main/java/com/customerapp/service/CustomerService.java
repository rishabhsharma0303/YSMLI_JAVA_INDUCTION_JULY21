package com.customerapp.service;
import java.util.*;

import com.customerapp.dao.Customer;
public interface CustomerService {
	public List<Customer> getAll();
	public Customer addCustomer(Customer customer);
	public Customer deleteCustomer(String customerId);
	public Customer updateCustomer(String customerId, Customer customer);
	public Customer getCustomerById(String customerId);
	
}
