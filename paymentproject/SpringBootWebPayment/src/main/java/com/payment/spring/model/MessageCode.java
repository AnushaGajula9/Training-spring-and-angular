package com.payment.spring.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="message_code")


public class MessageCode {
	@Id
	String msg_code;
	String description;
	public String getMsg_code() {
		return msg_code;
	}
	public void setMsg_code(String msg_code) {
		this.msg_code = msg_code;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "MessageCode [msg_code=" + msg_code + ", description=" + description + "]";
	}
	
	

}
