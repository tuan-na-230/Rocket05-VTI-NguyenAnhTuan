package com.vti.presentationlayer;

import java.util.List;
import java.util.Locale;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.Length;

import com.vti.dto.AccountDTO;
import com.vti.entity.enumerate.PositionName;
import com.vti.service.AccountService;
import com.vti.utils.ValidationUtils;
import com.vti.validation.AccountExists;
import com.vti.validation.PositionExists;

public class AccountController {

	private AccountService service;

	public AccountController() {
		service = new AccountService();
	}
	@Valid
	public void getAllAccounts(@Valid
			@Min(value = 1, message = "{para.pageNumber.Min}") int pageNumber, 
			@Min(value = 5, message = "{para.pageSize.Min}") @Max(value = 20, message = "{para.pageSize.Max}") int pageSize, 
			@Length(max = 50, message = "{para.nameSearch.Length}") String usernameSearch, 
			@PositionExists PositionName filter) {
		
		Locale.setDefault(new Locale("vi", "VN"));
		
		if (ValidationUtils.validate(pageNumber) && ValidationUtils.validate(pageSize) && ValidationUtils.validate(usernameSearch) && ValidationUtils.validate(filter)) {
			// validate success
			List<AccountDTO> accountDTOs = service.getAllAccounts(pageNumber, pageSize, usernameSearch, filter);
		
			for (AccountDTO accountDTO : accountDTOs) {
				System.out.println(accountDTO);
			}
		}
	}

	public void createAccount(@Valid AccountDTO dto) {
		Locale.setDefault(new Locale("vi", "VN"));
		// Locale.setDefault(Locale.US);
		
		if (ValidationUtils.validate(dto)) {
			// validate success
			service.createAccount(dto);
		}
	}
	
	public void updateAccount(@Valid @AccountExists int id, @Valid AccountDTO dto) {
		Locale.setDefault(new Locale("vi", "VN"));
		// Locale.setDefault(Locale.US);
		
		if (ValidationUtils.validate(id) && ValidationUtils.validate(dto)) {
			// validate success
			service.updateAccount(id, dto);
		}
	}
	
	public void deleteAccount(int id) {
		service.deleteAccount((short) id);
	}
}
