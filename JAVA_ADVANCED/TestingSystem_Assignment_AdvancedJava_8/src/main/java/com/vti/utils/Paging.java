package com.vti.utils;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

public class Paging {
	
	@Min(value = 1, message = "{Department.getAllDepartments.page.Min}")
	private int page;
	
	@Min(value = 3, message = "{Department.getAllDepartments.size.Min}") 
	@Max(value = 20, message = "{Department.getAllDepartments.size.Max}")
	private int size;

	public Paging() {
	}

	public Paging(int page, int size) {
		this.page = page;
		this.size = size;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
}
