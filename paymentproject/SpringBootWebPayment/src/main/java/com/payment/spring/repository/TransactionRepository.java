package com.payment.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.payment.spring.model.Transaction;



public interface TransactionRepository extends JpaRepository<Transaction,Integer> {

}