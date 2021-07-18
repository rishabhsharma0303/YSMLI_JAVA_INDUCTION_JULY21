package com.empapp.entities;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Document(collection = "employees")
public class Employee {
	@Id
	private String id;
	@Indexed(direction = IndexDirection.ASCENDING)
	private String name;
	private String city;
	private int age;
	
	public Employee(String name,String city,  int age) {
		
		this.name = name;
		this.city=city;
		this.age = age;
	}
	
	
}
