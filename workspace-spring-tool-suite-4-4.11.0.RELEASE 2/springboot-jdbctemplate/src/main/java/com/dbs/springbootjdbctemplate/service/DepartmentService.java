package com.dbs.springbootjdbctemplate.service;

import java.awt.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.dbs.springbootjdbctemplate.dto.Department;
@Service
public interface DepartmentService {
	
	public Department CreateDepartment(Department department);
	public Department UpdateDepartment(String deptId,Department department);
	public Department DeleteDepartment(String deptId);
	public Optional<Department> getDepartmentById(String deptId);
	//public Optional<List<Department>> getDepartments();
	//public Optional<List<Department>> getDepartmentsByLastName(String empLastName);
	//public Optional<Employee> getEmployeesByIdAndLastName(int empId,String empLastName);

}
