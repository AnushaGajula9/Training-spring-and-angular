package com.example.paymentproject.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.paymentproject.dto.Customer;
import com.example.paymentproject.exception.EntityNotFoundException;
import com.example.paymentproject.service.CustomerServiceImpl;

@RestController
@CrossOrigin
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	CustomerServiceImpl customerService;
	
	@GetMapping("/test")
	public String test()
	{
		return "test";
	}
	
	@GetMapping(value="customer/{customer_id}")
	public ResponseEntity<?> getCustomerById(@PathVariable("customer_id") String customer_id)throws EntityNotFoundException
	{
Customer customer1 = customerService.findCustomerById(customer_id);
		
		
		return ResponseEntity.status(200).body(customer1);
	}

	

}
