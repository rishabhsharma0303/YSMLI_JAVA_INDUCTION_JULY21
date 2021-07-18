package com.demo.mapping.one2many.bi;

import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "dept_table_one_to_many_bi")
public class Dept {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int deptId;

	@Column(unique = true, nullable = false)
	private String deptCode;
	private String deptName;
	private String deptHead;


	
	@OneToMany(mappedBy = "dept", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	public List<Employee> employees = new ArrayList<>();

	
	public String getDeptCode() {
		return deptCode;
	}

	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getDeptHead() {
		return deptHead;
	}

	public void setDeptHead(String deptHead) {
		this.deptHead = deptHead;
	}

	public Dept(String deptCode, String deptName, String deptHead) {
		super();
		this.deptCode = deptCode;
		this.deptName = deptName;
		this.deptHead = deptHead;
	}

	public Dept() {
	}

}
