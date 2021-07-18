package com.demo.mapping.inh.table_per_con;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "account_table")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS) //table per concreate class!
public  abstract class Account {
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	private int accountId;
	private String accountHolderName;
	@Column(nullable = false)
	private double balance;
	
	
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public String getAccountHolderName() {
		return accountHolderName;
	}
	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public Account( String accountHolderName, double balance) {
		this.accountHolderName = accountHolderName;
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", accountHolderName=" + accountHolderName + ", balance=" + balance
				+ "]";
	}
	public Account() {}

}







