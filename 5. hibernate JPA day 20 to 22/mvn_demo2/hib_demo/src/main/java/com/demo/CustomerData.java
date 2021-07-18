package com.demo;
//this is not a entity, it is a wrapper , i am telling hib hey do one
//thing take take this object and project op with it
public class CustomerData {
	private String name;
	private String address;
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
	public CustomerData(String name, String address) {
		System.out.println("ctr of CustomerData is called...");
		this.name = name;
		this.address = address;
	}
	public CustomerData() {}
	@Override
	public String toString() {
		return "CustomerData [name=" + name + ", address=" + address + "]";
	}
	
	
	
	
}
