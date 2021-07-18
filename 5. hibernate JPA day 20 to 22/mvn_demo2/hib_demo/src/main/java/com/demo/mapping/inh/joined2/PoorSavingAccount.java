package com.demo.mapping.inh.joined2;

import javax.persistence.Entity;

@Entity
public class PoorSavingAccount extends SavingAccount{
	private int subsidy;

	public int getSubsidy() {
		return subsidy;
	}

	public void setSubsidy(int subsidy) {
		this.subsidy = subsidy;
	}

	public PoorSavingAccount(String accountHolderName, double balance, double intrestRate, int subsidy) {
		super(accountHolderName, balance, intrestRate);
		this.subsidy = subsidy;
	}

	@Override
	public String toString() {
		return "PoorSavingAccount [subsidy=" + subsidy + "]"+super.toString();
	}

	public PoorSavingAccount() {
	}

	
	
}
