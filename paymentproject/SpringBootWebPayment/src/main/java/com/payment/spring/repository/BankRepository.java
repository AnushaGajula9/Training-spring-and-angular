
   
package com.payment.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.payment.spring.model.Bank;

public interface BankRepository extends JpaRepository<Bank,String>{

}