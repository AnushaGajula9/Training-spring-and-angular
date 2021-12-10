package com.dbs.springbootjdbctemplate.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dbs.springbootjdbctemplate.dto.Department;
import com.dbs.springbootjdbctemplate.dto.Employee;
import com.dbs.springbootjdbctemplate.service.DepartmentService;

@RestController 
@RequestMapping("/dept")


public class DepartmentController {
	@Autowired
	DepartmentService departmentService;
	
	
	@GetMapping("/test")
	public String test()
	{
		return "test";
	}
	@PostMapping("/create")//json to javaobject
	public ResponseEntity<?> addDepartment(@RequestBody Department department)
	{
		//Department department1 = departmentService.CreateDepartment(department);
		
		
		Optional  optional = departmentService.getDepartmentById(department.getDeptId());
		if(optional.isPresent())
		{
			Map<String, String> map = new HashMap<>();
			map.put("message", "record already exists");
			return ResponseEntity.status(400).body(map);
		}
				
			
				
		Department department1 = departmentService.CreateDepartment(department);
		if(department1!=null) {
		return ResponseEntity.status(201).body(department);
		}
		else
		{
			return ResponseEntity.status(400).body("details are not proper");
		}
		
		//javaobject to json 
	}
	

	@GetMapping("/{id}")
	public ResponseEntity<?> getDepartmentById(@PathVariable ("id")String id) {
		
		Optional optional = departmentService.getDepartmentById(id);
		
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
