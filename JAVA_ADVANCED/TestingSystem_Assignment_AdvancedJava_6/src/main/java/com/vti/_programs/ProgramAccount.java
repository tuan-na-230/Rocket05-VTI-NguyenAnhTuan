package com.vti._programs;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.vti.dto.AccountDTO;
import com.vti.entity.enumerate.PositionName;
import com.vti.entity.enumerate.SalaryName;
import com.vti.presentationlayer.AccountController;

public class ProgramAccount {

	public static void main(String[] args) throws ParseException {
		
		/*
		 * Database có tạo PROCEDURE để delete Account
		 * 
		 * >> File source database trong thư mục:  src\main\resources
		 * 
		 * 					MUST RUN
		 * 
		 */
		
		
		AccountController controller = new AccountController();

		System.out.println("\n\n***********CREATE ACCOUNT***********");

		String email = "huy1@gmail.com";
		String username = "danghuy1";
		String firstName = "Le"; 
		String lastName = "Dang Huy";
		String departmentName = "Giám đốc Demo"; 
		PositionName positionName = PositionName.DEV;
		SalaryName salaryName = SalaryName.ScrumMaster;
		
		String sDate = "15/09/2020";  
	    Date createDate = new SimpleDateFormat("dd/MM/yyyy").parse(sDate);
		//Date createDate = new Date();
		
		AccountDTO account = new AccountDTO(email, username, firstName, lastName, departmentName, positionName.getValue(), salaryName.getValue(), createDate);

		controller.createAccount(account);
		
		
		System.out.println("\n\n***********GET ALL ACCOUNTS***********");
		int pageNumber = 0;
		int pageSize = 200;
		String usernameSearch = "danghuy1";
		PositionName filter = PositionName.DEV;
		controller.getAllAccounts(pageNumber, pageSize, usernameSearch, filter);
		
		System.out.println("\n\n***********UPDATE ACCOUNT***********");
		String email1 = "huy4341@gmail.com";
		String username1 = "danghuy143";
		String firstName1 = "Nguyenxyfgdddddffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffz"; 
		String lastName1 = "Dang Huyyyy423432yy";
		String departmentName1 = "Giám đốc Demo"; 
		PositionName positionName1 = PositionName.ScrumMaster;
		SalaryName salaryName1 = SalaryName.ScrumMaster;
		
		String sDate1 = "15/09/2020";  
	    Date createDate1 = new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);
		//Date createDate2 = new Date();
		
		AccountDTO account1 = new AccountDTO(email1, username1, firstName1, lastName1, departmentName1, positionName1.getValue(), salaryName1.getValue(), createDate1);
		controller.updateAccount(-14, account1);
		
		System.out.println("\n\n***********DELETE ACCOUNT***********");
		controller.deleteAccount(7);
	}

}
