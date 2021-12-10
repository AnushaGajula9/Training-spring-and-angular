package com.payment.spring.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payment.spring.model.Customer;
import com.payment.spring.repository.CustomerRepository;

@Service
public class CustomerService {
	public CustomerService() {
		// TODO Auto-generated constructor stub
	}
	
	@Autowired
	private CustomerRepository custRepository;
	private static final Logger LOG = LoggerFactory.getLogger(CustomerService.class);
	public List<Customer> getCustomers()
	{
		LOG.info("getCustomers");
		List<Customer> customers = new ArrayList<Customer>();
		this.custRepository.findAll().forEach(cust->customers.add(cust));
		return customers;
	}
	
	public Customer getCustomerDetails(String customerID) {
		Optional<Customer> customeroptional=custRepository.findById(customerID);
		if (customeroptional.isPresent())
		return customeroptional.get();
		return null;
		

		}
	
	public  Customer findCustomerById(String id)
	{	LOG.info("findCustomerById");
		try {
			Optional<Customer> cust = this.custRepository.findById(id);
			return cust.orElseThrow(()->{
	
				return new EntityNotFoundException("Customer with "+id + " does not exist");
			});
		}catch(IllegalArgumentException e )
		{
			return null;
		}
	}

	
	public boolean sendMoney(Customer senderAcc,double amount) {
		LOG.info("sendMoney");
		String senderAccNo = senderAcc.getCustomerid();
	    senderAcc = this.findCustomerById(senderAccNo);
		if (senderAcc.getClearbalance() > amount || senderAcc.getOverdraftflag().equalsIgnoreCase("Yes") ) {
			senderAcc.setClearbalance(senderAcc.getClearbalance()-amount);
			custRepository.save(senderAcc);
			System.out.println("Balance : " + senderAcc.getClearbalance());
			return true;
		}
		return false;
	}
	
}