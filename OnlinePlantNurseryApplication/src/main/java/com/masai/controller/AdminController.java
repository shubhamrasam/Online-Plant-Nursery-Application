package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.Admin;
import com.masai.service.AdminService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/admins")
public class AdminController {
	@Autowired
	private AdminService adminservice;
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping
	public ResponseEntity<Admin> saveAdminHandler(@Valid @RequestBody Admin admin){
		return new ResponseEntity<>(adminservice.addAdmin(admin),HttpStatus.OK);
	}
	
	

}
