package com.customerapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.customerapp.dao.Customer;
import com.customerapp.service.CustomerService;

@SpringBootApplication
public class CustomerApplication implements CommandLineRunner {

	@Autowired
	private CustomerService customerService;
	
	public static void main(String[] args) {
		SpringApplication.run(CustomerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Customer customer=new Customer("tarun", "delhi", "5454545454", "t@gmail.com");
		Customer customer2=new Customer("ekta", "delhi", "5454995454", "e@gmail.com");
		customerService.addCustomer(customer);
		customerService.addCustomer(customer2);
		
		
	}

}
