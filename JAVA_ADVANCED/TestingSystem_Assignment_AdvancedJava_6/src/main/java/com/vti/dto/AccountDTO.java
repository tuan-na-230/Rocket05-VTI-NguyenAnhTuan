package com.vti.dto;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;

import org.hibernate.validator.constraints.Length;

import com.vti.entity.Account;
import com.vti.entity.Department;
import com.vti.entity.Position;
import com.vti.entity.Salary;
import com.vti.entity.enumerate.PositionName;
import com.vti.entity.enumerate.SalaryName;
import com.vti.service.DepartmentService;
import com.vti.service.PositionService;
import com.vti.service.SalaryService;
import com.vti.validation.EmailNotExists;
import com.vti.validation.PositionExists;
import com.vti.validation.SalaryExists;
import com.vti.validation.UsernameNotExists;

public class AccountDTO {

	@NotBlank(message = "{accountDto.email.NotBlank}")
	@Length(max = 50, message = "{accountDto.email.Length}")
	@Email(message = "{accountDto.email.Email}")
	@EmailNotExists
	private String email;

	@NotBlank(message = "{accountDto.username.NotBlank}")
	@Length(max = 50, message = "{accountDto.username.Length}")
	@UsernameNotExists
	private String username;

	@NotBlank(message = "{accountDto.firstName.NotBlank}")
	@Length(max = 50, message = "{accountDto.firstName.Length}")
	private String firstName;

	@NotBlank(message = "{accountDto.lastName.NotBlank}")
	@Length(max = 50, message = "{accountDto.lastName.Length}")
	private String lastName;
	
	@NotBlank(message = "{accountDto.departmentName.NotBlank}")
	private String departmentName;
	
	//@NotBlank(message = "{accountDto.positionName.NotBlank}")
	@PositionExists
	private String positionName;
	
	//@NotBlank(message = "{accountDto.salaryName.NotBlank}")
	@SalaryExists
	private String salaryName;
	
	//@NotBlank(message = "{accountDto.createDate.NotBlank}")
	@PastOrPresent(message = "{accountDto.createDate.PastOrPresent}")
	private Date createDate;

	public AccountDTO() {
	}
	
	public AccountDTO(String email, String username, String firstName, String lastName, String departmentName,
			String positionName, String salaryName, Date createDate) {
		this.email = email;
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.departmentName = departmentName;
		this.positionName = positionName;
		this.salaryName = salaryName;
		this.createDate = createDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getPositionName() {
		return positionName;
	}

	public void setPositionName(PositionName positionName) {
		this.positionName = positionName.getValue();
	}

	public String getSalaryName() {
		return salaryName;
	}

	public void setSalaryName(SalaryName salaryName) {
		this.salaryName = salaryName.getValue();
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Account toEntity() {
		
		DepartmentService departmentService = new DepartmentService();
		PositionService positionService = new PositionService();
		SalaryService salaryService = new SalaryService();
		
		Department department = departmentService.getDepartmentByName(departmentName);
		Position position = positionService.getPositionByName(PositionName.of(positionName));
		Salary salary = salaryService.getSalaryByName(SalaryName.of(salaryName));
		
		return new Account(email, username, firstName, lastName, department, position, salary, createDate);
	}

	@Override
	public String toString() {
		return "AccountDTO [email=" + email + ", username=" + username + ", firstName=" + firstName + ", lastName="
				+ lastName + ", departmentName=" + departmentName + ", positionName=" + positionName + ", salaryName="
				+ salaryName + ", createDate=" + createDate + "]";
	}
}
