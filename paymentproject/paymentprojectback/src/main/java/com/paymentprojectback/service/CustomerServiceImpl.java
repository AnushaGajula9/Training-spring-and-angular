package com.paymentprojectback.service;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paymentprojectback.dto.Customer;
import com.paymentprojectback.exception.UserNotFoundException;
import com.paymentprojectback.repository.CustomerRepository;

@Service
public class CustomerServiceImpl {
	@Autowired
	 CustomerRepository customerRepository;
	
	public Customer findCustomerById(String customer_id) {
		return customerRepository.findCustomerById(customer_id)
				.orElseThrow(()-> new UserNotFoundException("Customer by id"+customer_id+"was not found"));
		
		

	}
	
	
	

}
