package com.dbs.springbootjdbctemplate.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.dbs.springbootjdbctemplate.dto.Department;
import com.dbs.springbootjdbctemplate.repository.DepartmentRepository;

@Component
@Scope()

public class DepartmentServiceImpl implements DepartmentService {
	@Autowired
	DepartmentRepository departmentRepository;
	

	@Override
	public Department CreateDepartment(Department department) {
		// TODO Auto-generated method stub
		return departmentRepository.save(department);
	}

	@Override
	public Department UpdateDepartment(String deptId, Department department) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Department DeleteDepartment(String deptId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Department> getDepartmentById(String deptId) {
		// TODO Auto-generated method stub
		return departmentRepository.findById(deptId);
	}

}
