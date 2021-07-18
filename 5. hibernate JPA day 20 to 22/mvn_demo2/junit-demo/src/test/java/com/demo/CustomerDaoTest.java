package com.demo;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CustomerDaoTest {
	
private CustomerDao customerDao;
	
	@Before
	public void setUp() {
		customerDao=new CustomerDaoImpl();
	}
	
	@Test(expected = CustomerNotFoundEx.class)
	public void find_customer_by_id_with_exception() {
		Customer customer=customerDao.findCustomerById(12);
		Assert.assertNotNull(customer);
	}
	
	@Test(timeout = 1200)
	public void find_customer_by_id_with_success() {
		Customer customer=customerDao.findCustomerById(1);
		Assert.assertNotNull(customer);
	}
	
	@After
	public void tearDown() {
		customerDao=null;
	}
	
}
