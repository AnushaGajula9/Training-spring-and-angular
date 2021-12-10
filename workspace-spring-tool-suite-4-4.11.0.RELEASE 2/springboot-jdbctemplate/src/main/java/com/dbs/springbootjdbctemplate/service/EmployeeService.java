package com.dbs.springbootjdbctemplate.service;

import java.util.List;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.dbs.springbootjdbctemplate.dto.Employee;
import com.dbs.springbootjdbctemplate.exception.EntityNotFoundException;
@Service
public interface EmployeeService {
	public Employee CreateEmployee(Employee employee);
	public Employee UpdateEmployee(int  empId,Employee employee);
	//public Employee deleteEmployee(int empId);
	public Employee getEmployeeById(int empId) throws EntityNotFoundException;
	public Optional<List<Employee>> getEmployees();
	public Optional<List<Employee>> getEmployeesByLastName(String empLastName);
	public Optional<Employee> getEmployeesByIdAndLastName(int empId,String empLastName);
	public void deleteAll();
	public void deleteById(int empId);
	
}
