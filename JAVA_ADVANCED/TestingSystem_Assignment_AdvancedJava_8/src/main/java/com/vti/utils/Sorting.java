package com.vti.utils;

import javax.validation.constraints.Size;

public class Sorting {
	
	@Size(max = 30, message = "{Department.getAllDepartments.filter.Size}")
	private String field;
	private String type;

	public Sorting() {
	}

	public Sorting(String field, String type) {
		this.field = field;
		this.type = type;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
