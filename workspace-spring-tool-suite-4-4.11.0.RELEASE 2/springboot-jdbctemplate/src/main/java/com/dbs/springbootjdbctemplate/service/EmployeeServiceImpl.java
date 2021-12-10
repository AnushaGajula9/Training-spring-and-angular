package com.dbs.springbootjdbctemplate.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.dbs.springbootjdbctemplate.dto.Employee;
import com.dbs.springbootjdbctemplate.exception.EntityNotFoundException;
import com.dbs.springbootjdbctemplate.repository.EmployeeRepository;


@Component
@Scope()
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
    EmployeeRepository employeeRepository;

	@Override
	public Employee CreateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeeRepository.save(employee);
	}

	@Override
	public Employee UpdateEmployee(int empId, Employee employee) {
		// TODO Auto-generated method stub
		return null;
	}

	/*@Override
	public Employee deleteEmployee(int empId) {
		// TODO Auto-generated method stub
		return null;
	}*/

	@Override
	public Employee getEmployeeById(int empId) throws EntityNotFoundException{
		// TODO Auto-generated method stub
		Optional<Employee> optional =  employeeRepository.findById(empId);
		if(optional.isPresent()) {
			return optional.get();
		}
		else {
			//optional.orElseThrow(()-> new EntityNotFoundException("record not found"));
			//return null;  or
			
			throw new EntityNotFoundException("record not found");
			
		}
	}

	@Override
	public Optional<List<Employee>> getEmployees() {
		// TODO Auto-generated method stub
		
		List<Employee> employees = employeeRepository.findAll();
		if(employees.isEmpty())
		{
			return Optional.empty();
			
		}
		else
			return Optional.of(employees);
				
		
	}

	public Optional<List<Employee>> getEmployeesByLastName(String empLastName)
	{
		return employeeRepository.findByEmpLastName(empLastName);
	}

	public Optional<Employee> getEmployeesByIdAndLastName(int empId,String empLastName)
	{
		return employeeRepository.findByEmpIdAndEmpLastName( empId, empLastName);
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		employeeRepository.deleteAll();
	}

	@Override
	public void deleteById(int empId) {
		// TODO Auto-generated method stub
		employeeRepository.deleteById(empId);
		
	}

	
	


}
