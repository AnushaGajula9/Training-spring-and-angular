package com.payment.spring.model;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Customer {
	@Id
	private String customerid;
	private String accountholdername;
	private String overdraftflag;
	private double clearbalance;
	boolean isbank;
	
	
	public Customer() {
		// TODO Auto-generated constructor stub
	}
	public Customer(String customerid, String accountholdername, String overdraftflag, double clearbalance) {
		super();
		this.customerid = customerid;
		this.accountholdername = accountholdername;
		this.overdraftflag = overdraftflag;
		this.clearbalance = clearbalance;

	}
	public String getCustomerid() {
		return customerid;
	}
	public void setCustomerid(String customerid) {
		this.customerid = customerid;
	}
	public String getAccountholdername() {
		return accountholdername;
	}
	public void setAccountholdername(String accountholdername) {
		this.accountholdername = accountholdername;
	}
	public String getOverdraftflag() {
		return overdraftflag;
	}
	public void setOverdraftflag(String overdraftflag) {
		this.overdraftflag = overdraftflag;
	}
	public double getClearbalance() {
		return clearbalance;
	}
	public void setClearbalance(double clearbalance) {
		this.clearbalance = clearbalance;
	}
	public boolean isIsbank() {
		return isbank;
	}
	public void setIsbank(boolean isbank) {
		this.isbank = isbank;
	}

	
	@Override
	public String toString() {
		return "Customer [customerid=" + customerid + ", accountholdername=" + accountholdername + ", overdraftflag="
				+ overdraftflag + ", clearbalance=" + clearbalance +  ", getOverdraft()="
						+ getOverdraftflag() +", isIsbank()=" + isIsbank() +"]";
	}
}