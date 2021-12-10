package com.example.paymentproject.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.paymentproject.dto.Customer;
import com.example.paymentproject.exception.UserNotFoundException;
import com.example.paymentproject.repository.CustomerRepository;

@Service
public class CustomerServiceImpl {
	@Autowired
	 CustomerRepository customerRepository;
	
	public Customer findCustomerById(String customer_id) {
		return customerRepository.findCustomerById(customer_id)
				.orElseThrow(()-> new UserNotFoundException("Customer by id"+customer_id+"was not found"));
		
		

	}
	
	
	

}
