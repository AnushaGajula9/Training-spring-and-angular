package com.payment.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.payment.spring.model.Customer;



public interface CustomerRepository extends JpaRepository<Customer,String>{

}