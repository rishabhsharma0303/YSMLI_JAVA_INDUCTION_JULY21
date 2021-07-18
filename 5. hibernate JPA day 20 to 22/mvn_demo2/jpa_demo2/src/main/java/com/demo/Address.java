package com.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SecondaryTable;
import javax.persistence.SecondaryTables;
import javax.persistence.Table;

@Entity
@Table(name = "address")
@SecondaryTables({
	@SecondaryTable(name = "address_details"),
	@SecondaryTable(name = "address_details2")
})
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String address;
	private String street1;
	
	@Column(table = "address_details")
	private String street2;
	@Column(table = "address_details")
	private String state;
	@Column(table = "address_details2")
	private String city;
	
	@Column(table = "address_details2")
	private String pin;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getStreet1() {
		return street1;
	}

	public void setStreet1(String street1) {
		this.street1 = street1;
	}

	public String getStreet2() {
		return street2;
	}

	public void setStreet2(String street2) {
		this.street2 = street2;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public Address(String address, String street1, String street2, String state, String city, String pin) {
		super();
		this.address = address;
		this.street1 = street1;
		this.street2 = street2;
		this.state = state;
		this.city = city;
		this.pin = pin;
	}

	public Address() {}
	
}
