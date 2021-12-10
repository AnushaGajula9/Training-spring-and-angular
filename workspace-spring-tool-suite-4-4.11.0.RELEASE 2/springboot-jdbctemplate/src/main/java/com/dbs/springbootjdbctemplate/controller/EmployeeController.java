package com.dbs.springbootjdbctemplate.controller;

import java.util.HashMap;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dbs.springbootjdbctemplate.dto.Department;
import com.dbs.springbootjdbctemplate.dto.Employee;
import com.dbs.springbootjdbctemplate.exception.EntityNotFoundException;
import com.dbs.springbootjdbctemplate.repository.DepartmentRepository;
import com.dbs.springbootjdbctemplate.service.EmployeeService;

@RestController
@RequestMapping("/employee") //it will apply controller level mapping this approach will help us to separate stuff
public class EmployeeController {
	
	//controller should talk to service
	@Autowired
	EmployeeService employeeService;
	@Autowired
	DepartmentRepository departmentRepository;
	
	@GetMapping("/test")
	public String test()
	{
		return "test";
	}
	
	//to add new employee record
	@PostMapping("/create")//json to javaobject
	public ResponseEntity<?> addEmployee( @RequestBody @Valid Employee employee) throws EntityNotFoundException {
		// response entity is responsible for sending teh response to client.
		
		
			//Employee employee3 = employeeService.getEmployeeById(employee.getEmpId());
		Optional<Department> optionalDepartment= departmentRepository.findById(employee.getDeparment().getDeptId());
		if(!optionalDepartment.isPresent()) {
			return ResponseEntity.unprocessableEntity().build();
			
		}
			Employee employee2 =  employeeService.CreateEmployee(employee);
			if(employee2!=null)
			return ResponseEntity.status(201).body(employee);
			else
              return ResponseEntity.status(400).body("details are not proper");
		 
		
		
		
		
		
			
		// we should return status code 201
		// failure 400 bad req. 404 something. 
		// java object to JSON.
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getEmployeeById(@PathVariable ("id")int id) throws EntityNotFoundException {
		
		Employee employee = employeeService.getEmployeeById(id);
		
		
		return ResponseEntity.status(200).body(employee);
	
		
		
	
}
	/*@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteById(@PathVariable("id") int id)
	{
		Employee employee= employeeService.deleteEmployee(id);
		if(employee!=null)
		{
			return ResponseEntity.status(204).body("record deleted successfully");
		}
		else
		{
			return ResponseEntity.status(404).body("record not found");
		}
		 
	}*/
		 
	
	@DeleteMapping
	public void deleteAll() {
		employeeService.deleteAll();	
		
	}
	
	@GetMapping("/all")
	public ResponseEntity<?> getEmployees() throws EntityNotFoundException{
	Optional <List<Employee>>optional = employeeService.getEmployees();
	if(optional.isPresent())
	{
		return ResponseEntity.status(200).body(optional.get());
		
	}
	else
	{
		return ResponseEntity.noContent().build();
	}
	}
	
	
	
	

}
