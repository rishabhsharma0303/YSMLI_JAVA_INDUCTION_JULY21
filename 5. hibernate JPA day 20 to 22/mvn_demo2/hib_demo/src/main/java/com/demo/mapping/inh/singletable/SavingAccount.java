package com.demo.mapping.inh.singletable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@DiscriminatorValue("SA")
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