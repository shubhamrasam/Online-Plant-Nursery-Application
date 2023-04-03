package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.CustomerLoginDTO;
import com.masai.service.CustomerLoginService;
@RestController
@CrossOrigin(origins="*")
@RequestMapping("/customer")
public class CustomerLoginController {
	@Autowired
	private CustomerLoginService loginService;
	@PreAuthorize("hasRole('NORMAL')")
	@PostMapping("/login")
	public ResponseEntity<String> logInHandler(@RequestBody CustomerLoginDTO dto) {
		return new ResponseEntity<>(loginService.logIntoAccount(dto),HttpStatus.ACCEPTED);
	}
	@PreAuthorize("hasRole('NORMAL')")
	@PostMapping("/logout")
	public ResponseEntity<String> logoutInHandler(@RequestParam(required = false) String key) {
		return new ResponseEntity<>(loginService.logOutAccount(key),HttpStatus.OK);
	}

}
