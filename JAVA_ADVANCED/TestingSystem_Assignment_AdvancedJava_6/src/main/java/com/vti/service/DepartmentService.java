package com.vti.service;

import com.vti.entity.Department;
import com.vti.repository.DepartmentRepository;

public class DepartmentService {

	private DepartmentRepository repository;

	public DepartmentService() {
		repository = new DepartmentRepository();
	}
	
	public void createDepartment(Department department) {
		repository.createDepartment(department);
	}
	
	public Department getDepartmentByName(String name) {
		return repository.getDepartmentByName(name);
	}
	
	public boolean isDepartmentExistsByName(String name) {
		return repository.isDepartmentExistsByName(name);
	}
}
