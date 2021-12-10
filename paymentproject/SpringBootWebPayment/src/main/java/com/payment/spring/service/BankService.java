package com.payment.spring.service;

import java.util.Optional;
import javax.persistence.EntityNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.payment.spring.model.Bank;
import com.payment.spring.repository.BankRepository;

@Service
public class BankService {
	@Autowired
	private BankRepository bankRepository;
	private static final Logger LOG = LoggerFactory.getLogger(BankService.class);
	public BankService() {
		// TODO Auto-generated constructor stub
	}
	public Bank getRecieverDetails(String bic) {
		Optional<Bank> recieveroptional=bankRepository.findById(bic);
		if (recieveroptional.isPresent())
		return recieveroptional.get();
		
		return null;
		}
}