package com.paymentprojectback.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="Sender")
public class Customer implements Serializable  {
	@Id
	@Column(nullable=false,updatable=false)
	private String customer_id;
	private String account_holder_name;
	private double clear_balance;
	private String overdraft;
	
	public Customer(String customer_id,String account_holder_name,String overdraft,double clear_balance) {
		this.customer_id=customer_id;
		this.account_holder_name=account_holder_name;
		this.overdraft=overdraft;
		this.clear_balance=clear_balance;
		
		
	}
	public String getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id() {
		this.customer_id=customer_id;
	}
	public String getAccount_holder_name() {
		return account_holder_name;
	}
	public void setAccount_holder_name() {
		this.account_holder_name=account_holder_name;
	}
	public String getOverdraft() {
		return overdraft;
	}
	public void setOverdraft() {
		this.overdraft=overdraft;
	}
	public double getClear_balance() {
		return clear_balance;
	}
	public void setCLear_balance() {
		this.clear_balance=clear_balance;
	}
	
	@Override
	public String toString() {
		return "Customer[customer_id="+customer_id+ ",account_holder_name="
	+account_holder_name+",overdraft="+overdraft + ",clear_balance="+clear_balance+"]";
		
	}


}
