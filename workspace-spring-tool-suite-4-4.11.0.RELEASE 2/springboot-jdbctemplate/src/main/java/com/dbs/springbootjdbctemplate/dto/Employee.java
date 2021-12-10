package com.dbs.springbootjdbctemplate.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="employeetbl3")

public class Employee implements Serializable  {
	@Id
	@Column(name="emp_id")
	@Min(1)
	@Max(100000)
	
	private int empId;
	@NotNull
	@NotBlank
	private String empFirstName;
	@NotBlank
	private String empLastName;
	private String address;
	@NotNull
	private float empSal;
	
	@ManyToOne
	private Department deparment;
	
}
