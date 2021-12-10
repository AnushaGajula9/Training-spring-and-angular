package com.paymentprojectback.repository;

import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.paymentprojectback.dto.Customer;

@Repository
public interface CustomerRepository  extends JpaRepository<Customer, String>{
	
	Optional<Customer> findCustomerById(String customer_id);

}
