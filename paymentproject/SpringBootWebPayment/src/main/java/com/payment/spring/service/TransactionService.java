package com.payment.spring.service;

import java.time.LocalDate;


import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payment.spring.model.Customer;
import com.payment.spring.model.Transaction;
import com.payment.spring.repository.TransactionRepository;
@Service
public class TransactionService {
	@Autowired
	private TransactionRepository transactionRepository;
	@Autowired
	private CustomerService customerService;
	private static final Logger LOG = LoggerFactory.getLogger(TransactionService.class);
	SdnChecker sdn = new SdnChecker();
	
	public List<Transaction> getAllTransactions(){
		List<Transaction> t = new ArrayList<Transaction>();
		t = this.transactionRepository.findAll();
		return t;
		
	}
	
	public boolean checkBalance(String act_num,double amt)
	{
		double transaction_fee = (0.25/100)*amt;
		double total_amt_transfer = amt + transaction_fee;
        double clear_balance=customerService.findCustomerById(act_num).getClearbalance();
		
		String check_overdraft = customerService.findCustomerById(act_num).getOverdraftflag();

	if(total_amt_transfer < clear_balance)
		{
			return true;
		}
		else
		{
			if(check_overdraft.equals("yes"))
				return true;
			else
				return false;
		}
	}
		
	
	public Transaction insertTransaction(Transaction transaction)
	{
		return transactionRepository.save(transaction);
	}
	
}