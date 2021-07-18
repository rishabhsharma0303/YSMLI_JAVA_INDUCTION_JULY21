package com.demo.compsitepk;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class CustomerKey implements Serializable{
	private int id;
	private String aadharCard;
	
	public CustomerKey(int id, String aadharCard) {
		this.id = id;
		this.aadharCard = aadharCard;
	}

	public CustomerKey() {}
	
	
}
