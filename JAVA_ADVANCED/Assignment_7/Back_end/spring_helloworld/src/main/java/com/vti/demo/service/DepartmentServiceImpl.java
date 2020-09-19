package com.vti.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.vti.demo.entity.Department;
import com.vti.demo.repository.DepartmentRepositoryImpl;
@Service
public class DepartmentServiceImpl implements DepartmentService {
	@Autowired
	private DepartmentRepositoryImpl departmentRepository;
	@Override
	public List<Department> getAllDepartments() {
		// TODO Auto-generated method stub
		return departmentRepository.getAllDepartments();
	}
	
	public void createDepartment(Department newDepartment) {
		departmentRepository.createDepartment(newDepartment);
	}
	
	public void updateDepartment(Department newDepartment) {
		// TODO Auto-generated method stub
		departmentRepository.updateDepartment(newDepartment);
	}
	
	public void delDepartment(short id) {
		// TODO Auto-generated method stub
		departmentRepository.deleteDepartment(id);
	}
}
