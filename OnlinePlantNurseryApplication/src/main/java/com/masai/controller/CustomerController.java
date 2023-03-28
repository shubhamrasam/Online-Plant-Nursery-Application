package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.Customer;
import com.masai.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
     @Autowired
	private CustomerService customerService;
     
     @PostMapping
 	public ResponseEntity<Customer> saveCustomerHandler(@RequestBody Customer customer){
 		return new ResponseEntity<>(customerService.addCustomer(customer),HttpStatus.CREATED);
 	}
	
}
