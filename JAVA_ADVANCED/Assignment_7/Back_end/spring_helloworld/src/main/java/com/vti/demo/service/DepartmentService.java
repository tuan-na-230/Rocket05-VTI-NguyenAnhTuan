package com.vti.demo.service;

import java.util.List;

import com.vti.demo.entity.Department;

public interface DepartmentService {
	public List<Department> getAllDepartments();
	public void createDepartment(Department newDepartment);
	public void updateDepartment(Department newDepartment);
	public void delDepartment(short id);
}
