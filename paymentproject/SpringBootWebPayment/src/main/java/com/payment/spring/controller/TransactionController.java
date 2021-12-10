package com.payment.spring.controller;


import java.util.List;
import java.io.IOException;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.payment.spring.model.ResponsePage;
import com.payment.spring.model.Transaction;
import com.payment.spring.model.TransactionBody;
import com.payment.spring.service.BankService;
import com.payment.spring.service.CustomerService;
import com.payment.spring.service.MessageCodeService;
import com.payment.spring.service.SdnChecker;
import com.payment.spring.service.TransactionService;


@RestController
@CrossOrigin()
@RequestMapping
public class TransactionController {
	
	@Autowired
	CustomerService customerService;

	@Autowired
	BankService bankBicService;

	@Autowired
	MessageCodeService mesaCodeService;


	@Autowired
	TransactionService transactionService;

	@PostMapping(value="transaction")
	public ResponseEntity<Object> processingTransaction(@RequestBody TransactionBody transactionBody)
	{
		try{
				SdnChecker sdnCheckerService = new SdnChecker();
				if(sdnCheckerService.checker(transactionBody.getReceiver_account_name()))
				{
						if(transactionService.checkBalance(transactionBody.getCustomer_id(), transactionBody.getAmount()))
						{
							double total_money_deduct = transactionBody.getAmount()+(0.25/100)*transactionBody.getAmount();
							customerService.updateCheckbalance(transactionBody.getCustomer_id(), total_money_deduct);
							Transaction transaction = new Transaction();
							transaction.setCustomer(customerService.findCustomerById(transactionBody.getCustomer_id()));
							if(customerService.findCustomerById(transactionBody.getCustomer_id()).isIsbank())
								transaction.setTransfer_type("O");
							else
								transaction.setTransfer_type("C");
							
							transaction.setMessagecode(mesaCodeService.findbyMsgcode(transactionBody.getMessage_code()));
							transaction.setBank(bankBicService.getRecieverDetails(transactionBody.getReceiver_bic()));
							transaction.setAmount(total_money_deduct);
							transaction.setReceiver_name(transactionBody.getReceiver_account_name());
							transaction.setReceiver_account_number(transactionBody.getReceiver_account_number());
							transaction.setTimestamp(LocalDateTime.now());
							Transaction t1 = transactionService.insertTransaction(transaction);
							return new ResponseEntity<>(t1,HttpStatus.OK);
							
						}
						else
						{
							return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponsePage("failure","Hey buddy you dont have enough balance to do this transaction "));
						}
							
					}
				else
				{
					return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponsePage("failure","Danger!! Receiver account is blacklisted"));
				}
				}
				catch (IOException e) {
	                // TODO Auto-generated catch block
	                e.printStackTrace();
				}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponsePage("failure","Transaction failed"));
	}
	
	
}

