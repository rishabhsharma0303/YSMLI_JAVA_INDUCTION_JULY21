package com.demo.mapping.one2many.uni;

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

import org.hibernate.annotations.BatchSize;

@Entity
@Table(name = "dept_table_one_to_many_uni")
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int deptId;
	
	@Column(unique = true, nullable = false)
	private String deptCode;
	private String deptName;
	private String deptHead;

	public String getDeptCode() {
		return deptCode;
	}

	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}
	@BatchSize(size = 3)
	@JoinColumn(name = "did_fk", nullable = false)
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	public List<Employee> employees = new ArrayList<>();

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

	public Department(String deptCode, String deptName, String deptHead) {
		super();
		this.deptCode = deptCode;
		this.deptName = deptName;
		this.deptHead = deptHead;
	}

	public Department() {
	}

	@Override
	public String toString() {
		return "Department [deptId=" + deptId + ", deptCode=" + deptCode + ", deptName=" + deptName + ", deptHead="
				+ deptHead + "]";
	}

	
}
