package com.masai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.CustomerException;
import com.masai.model.Customer;
import com.masai.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerRepository customerRepo;

	@Override
	public Customer addCustomer(Customer customer) throws CustomerException {
		Customer existingCustomer=customerRepo.findByCustomerMobileNumber(customer.getCustomerMobileNumber());
		if(existingCustomer!=null) {
			throw new CustomerException("Customer Alresdy Register with mobile no");
		}
			
		return customerRepo.save(customer);
	}

	
	
	
}
