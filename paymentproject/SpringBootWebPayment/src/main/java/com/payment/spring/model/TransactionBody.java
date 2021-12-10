package com.payment.spring.model;

public class TransactionBody {
	String customer_id;
	String receiver_bic;
	String receiver_account_number;
	String receiver_account_name;
	String message_code;
	double amount;
	public String getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}
	
	public String getReceiver_bic() {
		return receiver_bic;
	}
	public void setReceiver_bic(String receiver_bic) {
		this.receiver_bic = receiver_bic;
	}
	public String getReceiver_account_number() {
		return receiver_account_number;
	}
	public void setReceiver_account_number(String receiver_account_number) {
		this.receiver_account_number = receiver_account_number;
	}
	public String getReceiver_account_name() {
		return receiver_account_name;
	}
	public void setReceiver_account_name(String receiver_account_name) {
		this.receiver_account_name = receiver_account_name;
	}
	
	public String getMessage_code() {
		return message_code;
	}
	public void setMessage_code(String message_code) {
		this.message_code = message_code;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public TransactionBody(String customer_id, String sender_bic, String receiver_bic, String receiver_account_number,
			String receiver_account_name, String transfer_type_code, String message_code, double amount) {
		super();
		this.customer_id = customer_id;
		this.receiver_bic = receiver_bic;
		this.receiver_account_number = receiver_account_number;
		this.receiver_account_name = receiver_account_name;
		this.message_code = message_code;
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "TransactionBody [customer_id=" + customer_id + ", receiver_bic=" + receiver_bic
				+ ", receiver_account_number=" + receiver_account_number + ", receiver_account_name="
				+ receiver_account_name + ", message_code=" + message_code + ", amount=" + amount
				+ ", getCustomer_id()=" + getCustomer_id() + ", getReceiver_bic()=" + getReceiver_bic()
				+ ", getReceiver_account_number()=" + getReceiver_account_number() + ", getReceiver_account_name()="
				+ getReceiver_account_name() + ", getMessage_code()=" + getMessage_code() + ", getAmount()="
				+ getAmount() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	

	
	

}

