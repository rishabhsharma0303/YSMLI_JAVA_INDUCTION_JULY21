package com.customerapp.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.customerapp.dao.Customer;
import com.customerapp.service.CustomerService;

@RestController
@RequestMapping(path = "api")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	//	-------get all customres---------
	@GetMapping(path = "customer")
	public List<Customer> getAllCustomers(){
		return customerService.getAll();
	}
	//	-------get an customre by id--------
	@GetMapping(path = "customer/{id}")
	public Customer getAnCustomer(@PathVariable(name = "id") String id){
		return customerService.getCustomerById(id);
	}
	
	//from the postman i will pass and josn object containing customer ob
	//that need to covert to java ie done by @RequestBody
	//	------add new customers
	@PostMapping(path = "customer")
	public Customer addAnCustomer(@RequestBody Customer customer){
		return customerService.addCustomer(customer);
	}
	
	
	@PutMapping(path = "customer/{id}")
	public Customer updateAnCustomer(@PathVariable(name = "id") String id, @RequestBody Customer customer){
		return customerService.updateCustomer(id, customer);
	}
	
	@DeleteMapping(path = "customer/{id}")
	public Customer deleteAnCustomer(@PathVariable(name = "id") String id){
		return customerService.deleteCustomer(id);
	}
	
}









