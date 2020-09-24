package com.vti.service;

import java.util.List;

import com.vti.entity.Salary;
import com.vti.entity.enumerate.SalaryName;
import com.vti.repository.SalaryRepository;

public class SalaryService {

	private SalaryRepository repository;

	public SalaryService() {
		repository = new SalaryRepository();
	}

	public List<Salary> getAllSalarys() {
		return repository.getAllSalarys();
	}
	
	public Salary getSalaryByName(SalaryName name) {
		return repository.getSalaryByName(name);
	}
	
	public boolean isSalaryExistsByName(SalaryName name) {
		return repository.isSalaryExistsByName(name);
	}
}
