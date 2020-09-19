package com.vti.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hello")
public class HelloController {
	
	@GetMapping(value="/test")
	public String hello() {
		System.out.println("hello from controller");
		String a = "123";
		return a;
	}

	@GetMapping(value="/postman")
	public ResponseEntity<?> postman() {
		return new ResponseEntity<>("Hello postman", HttpStatus.BAD_REQUEST);
	}
}
