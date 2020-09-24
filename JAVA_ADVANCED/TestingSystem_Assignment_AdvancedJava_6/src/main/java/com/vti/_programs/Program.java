package com.vti._programs;

import java.util.List;

import com.vti.dto.DepartmentDTO;
import com.vti.entity.Department;
import com.vti.repository.DepartmentRepository;

public class Program {
	public static void main(String[] args) {
		DepartmentRepository repository = new DepartmentRepository();

		System.out.println("***********GET ALL DEPARTMENTS***********");

		List<DepartmentDTO> departments = repository.getAllDepartments(0, 10, null, (short)0);

		for (DepartmentDTO department : departments) {
			System.out.println(department);
		}
		
		long countResult = repository.getTotalCount(null, (short)0);
		System.out.println("\nTổng số result: " + countResult);

		System.out.println("\n\n***********GET DEPARTMENT BY ID***********");

		DepartmentDTO departmentById = repository.getDepartmentByID((short) 6, null, (short)0);
		System.out.println(departmentById);

		System.out.println("\n\n***********GET DEPARTMENT BY NAME***********");

		DepartmentDTO departmentByName = repository.getDepartmenDTOtByName("Marketing");
		System.out.println(departmentByName);

		System.out.println("\n\n***********CREATE DEPARTMENT***********");

		Department departmentCreate = new Department();
		departmentCreate.setName("waiting");
		repository.createDepartment(departmentCreate);

		System.out.println("\n\n***********UPDATE DEPARTMENT 1***********");

		repository.updateDepartment((short) 3, "Security", (short)3, "NEU");
		
		System.out.println("\n\n***********GET DEPARTMENT BY ID***********");

		DepartmentDTO departmentById1 = repository.getDepartmentByID((short) 3, null, (short)0);
		System.out.println(departmentById1);

		System.out.println("\n\n***********DELETE DEPARTMENTS***********");
		repository.deleteDepartment((short) 5);

		System.out.println("***********CHECK DEPARTMENT EXISTS BY ID***********");
		System.out.println(repository.isDepartmentExistsByID((short) 1));

		System.out.println("***********CHECK DEPARTMENT EXISTS BY NAME***********");
		System.out.println(repository.isDepartmentExistsByName("waiting"));

	}
}
