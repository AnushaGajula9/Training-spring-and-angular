package com.payment.spring.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class Transaction {
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	Integer trans_id;
	double amount;
	String transfer_type;
	LocalDateTime timestamp;
	String receiver_name;
	String receiver_account_number;
	@ManyToOne
	@JoinColumn(name="customer_id")
	Customer customer;
	@ManyToOne
	@JoinColumn(name="receiver_bic")
	Bank bank;
	@ManyToOne
	@JoinColumn(name="msg_code")
	MessageCode messagecode;
	public Integer getTrans_id() {
		return trans_id;
	}
	public void setTrans_id(Integer trans_id) {
		this.trans_id = trans_id;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getTransfer_type() {
		return transfer_type;
	}
	public void setTransfer_type(String transfer_type) {
		this.transfer_type = transfer_type;
	}
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	public String getReceiver_name() {
		return receiver_name;
	}
	public void setReceiver_name(String receiver_name) {
		this.receiver_name = receiver_name;
	}
	public String getReceiver_account_number() {
		return receiver_account_number;
	}
	public void setReceiver_account_number(String receiver_account_number) {
		this.receiver_account_number = receiver_account_number;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Bank getBank() {
		return bank;
	}
	public void setBank(Bank bank) {
		this.bank = bank;
	}
	public MessageCode getMessagecode() {
		return messagecode;
	}
	public void setMessagecode(MessageCode messagecode) {
		this.messagecode = messagecode;
	}
	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Transaction [trans_id=" + trans_id + ", amount=" + amount + ", transfer_type=" + transfer_type
				+ ", timestamp=" + timestamp + ", receiver_name=" + receiver_name + ", receiver_account_number="
				+ receiver_account_number + ", customer=" + customer + ", bank=" + bank + ", messagecode=" + messagecode
				+ "]";
	}
	
	

}
