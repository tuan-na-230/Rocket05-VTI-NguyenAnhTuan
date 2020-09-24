package com.vti.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import com.vti.dto.DepartmentDTO;
import com.vti.entity.Department;
import com.vti.filter.FilterDepartment;
import com.vti.repository.DepartmentRepository;
import com.vti.utils.Paging;
import com.vti.utils.Sorting;
import com.vti.validation.group.onCreate;
import com.vti.validation.group.onUpdate;

@Component("DepartmentServiceImpl")
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentRepository departmentrepository;
	
	public List<DepartmentDTO> getAllDepartments(){
		return departmentrepository.getAllDepartments();
	}

	public List<DepartmentDTO> getAllDepartments(Paging paging, String search, FilterDepartment filter, Sorting sorting) {
		return departmentrepository.getAllDepartments(paging, search, filter, sorting);
	}
	
	public long getTotalCount(String search, String filter) {
		return departmentrepository.getTotalCount(search, filter);
	}

	public Department getDepartmentByID(short id) {
		return departmentrepository.getDepartmentByID(id);
	}

	public Department getDepartmentByName(String name) {
		return departmentrepository.getDepartmentByName(name);
	}

	@Validated(onCreate.class)
	public void createDepartment(@Valid Department department) {
		departmentrepository.createDepartment(department);
	}

	public void updateDepartment(short id, String newName) {
		departmentrepository.updateDepartment(id, newName);
	}

	@Validated(onUpdate.class)
	public void updateDepartment(@Valid Department department) {
		departmentrepository.updateDepartment(department);
	}

	public void deleteDepartment(short id) {
		departmentrepository.deleteDepartment(id);
	}

	public boolean isDepartmentExistsByID(short id) {
		return departmentrepository.isDepartmentExistsByID(id);
	}

	public boolean isDepartmentExistsByName(String name) {
		return departmentrepository.isDepartmentExistsByName(name);
	}
}
