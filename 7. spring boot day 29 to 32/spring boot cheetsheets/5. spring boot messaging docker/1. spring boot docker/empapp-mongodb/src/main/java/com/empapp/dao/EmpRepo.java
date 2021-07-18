package com.empapp.dao;
import java.util.*;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.empapp.entities.Employee;
@Repository
public interface EmpRepo extends MongoRepository<Employee, String>{
	@Query(value = "{city:?0}")
	List<Employee> findByCities(String city);
}
