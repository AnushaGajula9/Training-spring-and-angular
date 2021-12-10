package com.payment.spring.model;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
@Entity
public class Transaction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int transactionid;
	
	@OneToOne
	@JoinColumn(name="customerid")
	private Customer customer;
	
	@OneToOne
	@JoinColumn(name="receiverBIC")
	private Bank receiver;
	
	private String receiveraccountholdernumber;
	
	private String receiveraccountholdername;

	private String transfertypes;
	

	
	private String message;
	
	private double amount;
	
	private double transferfees;
	
	private LocalDate transferdate;
	
	public Transaction() {
		// TODO Auto-generated constructor stub
	}
	public Transaction(int transactionid, Customer customer, Bank receiver, String receiveraccountholdernumber,
			String receiveraccountholdername, String transfertypes, String message, double amount, double transferfees,
			LocalDate transferdate) {
		super();
		this.transactionid = transactionid;
		this.customer = customer;
		this.receiver = receiver;
		this.receiveraccountholdernumber = receiveraccountholdernumber;
		this.receiveraccountholdername = receiveraccountholdername;
		this.transfertypes = transfertypes;
		this.message = message;
		this.amount = amount;
		this.transferfees = transferfees;
		this.transferdate = transferdate;
	}
	
	public int getTransactionid() {
		return transactionid;
	}
	public void setTransactionid(int transactionid) {
		this.transactionid = transactionid;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Bank getReceiver() {
		return receiver;
	}
	public void setReceiver(Bank receiver) {
		this.receiver = receiver;
	}
	public String getReceiveraccountholdernumber() {
		return receiveraccountholdernumber;
	}
	public void setReceiveraccountholdernumber(String receiveraccountholdernumber) {
		this.receiveraccountholdernumber = receiveraccountholdernumber;
	}
	public String getReceiveraccountholdername() {
		return receiveraccountholdername;
	}
	public void setReceiveraccountholdername(String receiveraccountholdername) {
		this.receiveraccountholdername = receiveraccountholdername;
	}
	public String getTransfertypes() {
		return transfertypes;
	}
	public void setTransfertypes(String transfertypes) {
		this.transfertypes = transfertypes;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public double getTransferfees() {
		return transferfees;
	}
	public void setTransferfees(double transferfees) {
		this.transferfees = transferfees;
	}
	public LocalDate getTransferdate() {
		return transferdate;
	}
	public void setTransferdate(LocalDate transferdate) {
		this.transferdate = transferdate;
	}
	@Override
	public String toString() {
		return "Transaction [transactionid=" + transactionid + ", customer=" + customer + ", receiver=" + receiver
				+ ", receiveraccountholdernumber=" + receiveraccountholdernumber + ", receiveraccountholdername="
				+ receiveraccountholdername + ", transfertypes=" + transfertypes + ", message=" + message + ", amount="
				+ amount + ", transferfees=" + transferfees + ", transferdate=" + transferdate + "]";
	}
	
	
	
	
	
}