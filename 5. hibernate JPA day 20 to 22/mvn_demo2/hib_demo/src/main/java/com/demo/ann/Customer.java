package com.demo.ann;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name = "cust_table_full", schema = "yms_demo2")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, updatable = false)
	private Integer id;
	
	@Column(name = "cust_name", nullable = false, length = 100)
	private String name;
	
	@Column(name = "cust_address", nullable = false, length = 100)
	private String address;
	
	@Column(name = "cust_mobile", nullable = false, length = 100)
	private String mobile;
	
	@Column(name = "cust_email", nullable = false, length = 100)
	private String email;
	
	@Column(name = "cust_dob", nullable = false, length = 100)
	@Temporal(TemporalType.DATE)
	private Date dob;

	@Column(name = "cust_reg_date", nullable = false, length = 100)
	@Temporal(TemporalType.TIMESTAMP)
	private Date regDate;
	
	@Column(name = "cust_purchage_cap", nullable = false, precision = 3)
	private Double purchageCapacity;
	
	@Transient
	private String tempPassword;
	
	@Basic(fetch = FetchType.LAZY,optional = true)
	@Lob
    @Column(name = "photo", columnDefinition="BLOB")
    private byte[] photo;
	
	
	
	
	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	public String getTempPassword() {
		return tempPassword;
	}

	public void setTempPassword(String tempPassword) {
		this.tempPassword = tempPassword;
	}

	public Double getPurchageCapacity() {
		return purchageCapacity;
	}

	public void setPurchageCapacity(Double purchageCapacity) {
		this.purchageCapacity = purchageCapacity;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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

	public Customer(String name, String address, String mobile, String email, Date dob) {
		this.name = name;
		this.address = address;
		this.mobile = mobile;
		this.email = email;
		this.dob = dob;
	}

	public Customer(int id, String name, String address, String mobile, String email, Date dob) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.mobile = mobile;
		this.email = email;
		this.dob = dob;
	}

	public Customer() {
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", address=" + address + ", mobile=" + mobile + ", email="
				+ email + ", dob=" + dob + "]";
	}

}
