package com.payment.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payment.spring.model.MessageCode;
import com.payment.spring.repository.MessageCoderepo;

@Service
public class MessageCodeService {
	
	@Autowired
	MessageCoderepo messagecoderepo;
	
	public MessageCode findbyMsgcode(String msgcode)
	{
		java.util.Optional<MessageCode> optmsgcode = messagecoderepo.findById(msgcode);
		if(optmsgcode.isPresent())
		{
			return optmsgcode.get();
		}
		else
			return null;
		
		
		
	}

}
