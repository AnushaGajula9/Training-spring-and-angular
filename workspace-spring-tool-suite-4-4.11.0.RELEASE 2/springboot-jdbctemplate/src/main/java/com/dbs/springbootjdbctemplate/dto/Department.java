package com.dbs.springbootjdbctemplate.dto;

import javax.persistence.CascadeType;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name="deptTBL2")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department {
	
	
	private String deptName;
	@Id
	private String deptId;
	private String location;
	@OneToMany(mappedBy =  "department", cascade = CascadeType.REMOVE)
	private List<Employee> employees;
	
	

}
