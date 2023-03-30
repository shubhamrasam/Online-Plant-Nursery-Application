package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.CustomerException;
import com.masai.model.Customer;
import com.masai.model.CustomerLoginDTO;
import com.masai.service.CustomerService;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/customers")
public class CustomerServiceController {

	@Autowired
	private CustomerService customerService;

	@PostMapping
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) throws CustomerException {
		Customer addedCustomer = customerService.addCustomer(customer);
		return ResponseEntity.ok().body(addedCustomer);
	}

	@PutMapping("/{customerId}/{key}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable int customerId,@PathVariable String key, @RequestBody Customer customer)
			throws CustomerException {
		customer.setCustomerId(customerId);
		Customer updatedCustomer = customerService.updateCustomer(customerId,customer,key);
		return ResponseEntity.ok().body(updatedCustomer);
	}

	@DeleteMapping("/{customerId}/{key}")
	public ResponseEntity<String> deleteCustomer(@PathVariable int customerId,@PathVariable String key) throws CustomerException {
		customerService.deleteCustomer(customerId, key);
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/{customerId}/{key}")
	public ResponseEntity<Customer> viewCustomer(@PathVariable int customerId,@PathVariable String key) throws CustomerException {
		Customer customer = customerService.viewCustomer(customerId, key);
		return ResponseEntity.ok().body(customer);
	}

	@GetMapping
	public ResponseEntity<List<Customer>> viewAllCustomers() throws CustomerException {
		List<Customer> customers = customerService.viewAllCustomers();
		return ResponseEntity.ok().body(customers);
	}

	@PostMapping("/login")
	public ResponseEntity<String> validateCustomer(@RequestBody CustomerLoginDTO loginRequest)
			throws CustomerException {
		String customer = customerService.validateCustomer(loginRequest.getCustomerMobileNumber(), loginRequest.getCustomerPassword());
		return ResponseEntity.ok().body(customer);
	}
}
