package com.payment.spring.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.payment.spring.model.MessageCode;



public interface MessageCoderepo extends JpaRepository<MessageCode, String> {

}
