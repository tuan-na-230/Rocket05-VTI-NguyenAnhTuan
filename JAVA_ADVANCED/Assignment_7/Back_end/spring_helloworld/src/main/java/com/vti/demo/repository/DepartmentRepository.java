package com.vti.demo.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.vti.demo.entity.Department;

public interface DepartmentRepository {
	public List<Department> getAllDepartments();
}
