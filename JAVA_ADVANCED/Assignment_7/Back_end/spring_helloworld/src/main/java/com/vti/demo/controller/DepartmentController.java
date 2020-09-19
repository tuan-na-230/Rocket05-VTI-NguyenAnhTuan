package com.vti.demo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.vti.demo.entity.Department;
import com.vti.demo.service.DepartmentServiceImpl;

@Controller
@RequestMapping("/")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class DepartmentController {
	
	@Autowired
	private DepartmentServiceImpl departmentService;
	@GetMapping(value="/departments")
	public ResponseEntity<?> getList() {
		return new ResponseEntity<>(departmentService.getAllDepartments(), HttpStatus.OK);
	}
	
	@PostMapping(value="/departments")
	public ResponseEntity<?> postDepartment(@RequestBody Department newDepartment) {
		departmentService.createDepartment(newDepartment);
		return new ResponseEntity<>(newDepartment, HttpStatus.OK);
	}
	
	@PutMapping(value="/departments")
	public ResponseEntity<?> putDepartment(@RequestBody Department newDepartment) {
		System.out.println(newDepartment);
		departmentService.updateDepartment(newDepartment);
		return new ResponseEntity<>("ok", HttpStatus.OK);
	}
	
	@DeleteMapping(value="/departments")
	public ResponseEntity<?> delDepartment(@RequestBody Department newDepartment) {
		short id = newDepartment.getId();
		departmentService.delDepartment(id);
		return new ResponseEntity<>("ok", HttpStatus.OK);
	}
}
