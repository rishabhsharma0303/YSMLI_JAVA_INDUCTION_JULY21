package com.demo.mapping.inh.singletable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@DiscriminatorValue("CA")
public class CurrentAccount extends Account {
	
	private double overdraft;

	public CurrentAccount(String accountHolderName, double balance, double overdraft) {
		super(accountHolderName, balance);
		this.overdraft = overdraft;
	}

	public double getOverdraft() {
		return overdraft;
	}

	public void setOverdraft(double overdraft) {
		this.overdraft = overdraft;
	}

	@Override
	public String toString() {
		return "CurrentAccount [overdraft=" + overdraft + "]"+ super.toString();
	}

	public CurrentAccount() {
	}
}