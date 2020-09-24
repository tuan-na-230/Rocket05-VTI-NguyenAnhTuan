package com.vti.dto;

public class DepartmentDTO {
	private short id;
	private String name;
	private String nameAddress;
	
	public DepartmentDTO(short id, String name, String nameAddress) {
		super();
		this.id = id;
		this.name = name;
		this.nameAddress = nameAddress;
	}
	
	public short getId() {
		return id;
	}
	public void setId(short id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNameAddress() {
		return nameAddress;
	}
	public void setNameAddress(String nameAddress) {
		this.nameAddress = nameAddress;
	}
	
	@Override
	public String toString() {
		return "DepartmentDTO [id=" + id + ", name=" + name + ", nameAddress=" + nameAddress + "]";
	}
}
