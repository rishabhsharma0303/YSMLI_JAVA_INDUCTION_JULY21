package com.demo.mapping.many2many.bi;

import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "dept_table_many_to_many_bi")
public class Project {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pId;

	private String pName;
	private String pHead;
	
	@ManyToMany
	@JoinTable(name = "project_emp_jt", 
	joinColumns = @JoinColumn(name="pid_fk"),
	inverseJoinColumns = @JoinColumn(name="eid_fk"))
	private List<Employee> employees=new ArrayList<>();

	
	public List<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	public int getpId() {
		return pId;
	}
	public void setpId(int pId) {
		this.pId = pId;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public String getpHead() {
		return pHead;
	}
	public void setpHead(String pHead) {
		this.pHead = pHead;
	}


}
