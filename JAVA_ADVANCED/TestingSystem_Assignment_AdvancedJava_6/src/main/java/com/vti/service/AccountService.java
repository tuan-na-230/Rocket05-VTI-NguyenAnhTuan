package com.vti.service;

import java.util.List;

import com.vti.dto.AccountDTO;
import com.vti.entity.Account;
import com.vti.entity.Department;
import com.vti.entity.Position;
import com.vti.entity.enumerate.PositionName;
import com.vti.repository.AccountRepository;
import com.vti.repository.PositionRepository;

public class AccountService {

	private AccountRepository repository;

	public AccountService() {
		repository = new AccountRepository();
	}

	public List<AccountDTO> getAllAccounts(int pageNumber, int pageSize, String nameSearch, PositionName filter) {
		PositionRepository positionRepository = new PositionRepository();
		Position position = positionRepository.getPositionByName(filter);
		
		return repository.getAllAccounts(pageNumber, pageSize, nameSearch, position);
	}

	public Account getAccountByEmail(String email) {
		return repository.getAccountByEmail(email);
	}

	public void createAccount(AccountDTO dto) {
		
		DepartmentService departmentService = new DepartmentService();
		if(!departmentService.isDepartmentExistsByName(dto.getDepartmentName())) {
			Department department = new Department();
			department.setName(dto.getDepartmentName());
			departmentService.createDepartment(department);
		}

		Account entity = dto.toEntity();
		repository.createAccount(entity);
		
	}
	
	public void updateAccount(int id, AccountDTO account) {
		
		Account entity = account.toEntity();
		entity.setId((short)id);
		repository.updateAccount(entity);
		
	}
	
	public void deleteAccount(short id) {
		ExamService examService = new ExamService();
		examService.deleteExam(id);
		
		repository.deleteAccount(id);
	}
	
	public boolean isAccountExistsByID(int id) {
		return repository.isAccountExistsByID(id);
	}
	
	public boolean isAccountExistsByEmail(String email) {
		return repository.isAccountExistsByEmail(email);
	}
	
	public boolean isAccountExistsByUsername(String username) {
		return repository.isAccountExistsByUsername(username);
	}
}
