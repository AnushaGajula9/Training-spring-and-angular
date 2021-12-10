package com.paymentprojectback.controller;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.paymentprojectback.dto.Customer;
import com.paymentprojectback.exception.EntityNotFoundException;
import com.paymentprojectback.service.CustomerServiceImpl;

@RestController
@CrossOrigin
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	CustomerServiceImpl customerService;
	

	
	@GetMapping(value="customer/{customer_id}")
	public ResponseEntity<?> getCustomerById(@PathVariable("customer_id") String customer_id)throws EntityNotFoundException
	{
      Customer customer1 = customerService.findCustomerById(customer_id);
		
		
		return ResponseEntity.status(200).body(customer1);
	}

	

}
