package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.AdminLoginDTO;
import com.masai.service.AdminLoginService;

@RestController

public class AdminLoginController {
	 @Autowired
	private AdminLoginService loginService;
	
	@PostMapping("/admin/login")
	public ResponseEntity<String> logInHandler(@RequestBody AdminLoginDTO dto) {
		return new ResponseEntity<>(loginService.logIntoAccount(dto),HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/admin/logout")
	public ResponseEntity<String> logoutInHandler(@RequestParam(required = false) String key) {
		return new ResponseEntity<>(loginService.logOutAccount(key),HttpStatus.OK);
	}

}
