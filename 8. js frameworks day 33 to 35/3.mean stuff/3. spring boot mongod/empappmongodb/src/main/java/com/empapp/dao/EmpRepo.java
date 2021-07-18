package com.empapp.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.empapp.entities.Employee;
@Repository
public interface EmpRepo extends MongoRepository<Employee, String>{

}
