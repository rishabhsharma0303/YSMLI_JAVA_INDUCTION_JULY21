package com.demo.mapping.inh.joined2;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
public class SavingAccount extends Account {
	
	private double intrestRate;

	public SavingAccount(String accountHolderName, double balance, double intrestRate) {
		super(accountHolderName, balance);
		this.intrestRate = intrestRate;
	}

	public double getIntrestRate() {
		return intrestRate;
	}

	public void setIntrestRate(double intrestRate) {
		this.intrestRate = intrestRate;
	}

	@Override
	public String toString() {
		return "SavingAccount [intrestRate=" + intrestRate + "]"+ super.toString();
	}

	public SavingAccount() {}

	
	

}