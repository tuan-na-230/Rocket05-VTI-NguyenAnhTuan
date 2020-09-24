package com.vti.presentationlayer;

import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import com.vti.dto.AccountDTO;
import com.vti.entity.Salary;
import com.vti.entity.enumerate.SalaryName;
import com.vti.service.SalaryService;

public class SalaryController {

	private SalaryService service;

	public SalaryController() {
		service = new SalaryService();
	}

	public List<Salary> getAllSalarys() {
		return service.getAllSalarys();
	}

	public void createAccount(@Valid AccountDTO dto) {
		Locale.setDefault(new Locale("vi", "VN"));
		// Locale.setDefault(Locale.US);
		
	}
	
	public Salary getSalaryByName(SalaryName name) {
		return service.getSalaryByName(name);
	}
	
	public boolean isSalaryExistsByName(SalaryName name) {
		return service.isSalaryExistsByName(name);
	}
}
