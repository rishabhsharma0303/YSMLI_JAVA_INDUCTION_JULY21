package com.empapp.service;

import java.util.List;

import com.empapp.entities.Employee;

public interface EmployeeService {
	public List<Employee> getAll();
	public Employee getEmployeeById(String id);
	public Employee save(Employee emp);
	public Employee delete(String empId);
	public Employee update(String empId, Employee emp);
}