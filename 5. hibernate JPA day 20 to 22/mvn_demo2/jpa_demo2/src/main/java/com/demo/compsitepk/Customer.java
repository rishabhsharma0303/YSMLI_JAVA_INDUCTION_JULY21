package com.demo.compsitepk;

import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Table(name = "customer_table_jpa_2")
@Entity
 public class Customer {
	
	@EmbeddedId
	private CustomerKey key;
	
	private String name;
	private String address;
	private String mobile;
	private String email;
	private Date dob;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public CustomerKey getKey() {
		return key;
	}
	public void setKey(CustomerKey key) {
		this.key = key;
	}
	@Override
	public String toString() {
		return "Customer [key=" + key + ", name=" + name + ", address=" + address + ", mobile=" + mobile + ", email="
				+ email + ", dob=" + dob + "]";
	}

	
	
	
	
	
}
