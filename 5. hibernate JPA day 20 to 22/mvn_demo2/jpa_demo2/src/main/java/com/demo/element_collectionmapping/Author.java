package com.demo.element_collectionmapping;

import java.util.*;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "author_table_jpa")
@Entity
public class Author {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	
	@Column(name="phone")
	@CollectionTable(name = "phone_table")
	@ElementCollection(fetch = FetchType.EAGER)
	private List<String>phones=new ArrayList<>();
	
	@Column(name="email")
	@CollectionTable(name = "email_table")
	@ElementCollection(fetch = FetchType.LAZY)
	private  List<String>emails=new ArrayList<>();
	
	public void addPhone(String phone) {
		phones.add(phone);
	}
	
	public void addEmail(String email) {
		emails.add(email);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<String> getPhones() {
		return phones;
	}
	
	public List<String> getEmails() {
		return emails;
	}
	
	@Override
	public String toString() {
		return "Author [id=" + id + ", name=" + name + ", phones=" + phones + ", emails=" + emails + "]";
	}
	
	
	
	
	
}

