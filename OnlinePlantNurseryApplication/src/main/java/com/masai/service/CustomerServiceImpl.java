package com.masai.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.CustomerException;
import com.masai.exception.LoginException;
import com.masai.model.Customer;
import com.masai.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepo;

	@Override
	public Customer addCustomer(Customer customer,String key) throws CustomerException,LoginException {
		Customer existingCustomer = customerRepo.findByCustomerMobileNumber(customer.getCustomerMobileNumber());
		if (existingCustomer != null) {
			throw new CustomerException("Customer Already Register with mobile no");
		}

		return customerRepo.save(customer);
	}

	@Override
	public Customer updateCustomer(Customer customer,String key) throws CustomerException,LoginException {

		Customer savedC = customerRepo.findById(customer.getCustomerId()).orElseThrow(() -> new CustomerException(
				"There is not customer for update with thid id " + customer.getCustomerId()));

		if (customer.getCustomerMobileNumber() != null) {
			savedC.setCustomerMobileNumber(customer.getCustomerMobileNumber());
		}

		if (customer.getUserName() != null) {
			savedC.setUserName(customer.getUserName());
		}

		if (customer.getAddress() != null) {
			savedC.setAddress(customer.getAddress());
		}

		if (customer.getCustomerPassword() != null) {
			savedC.setCustomerPassword(customer.getCustomerPassword());
		}

		Customer saved = customerRepo.save(savedC);

		return saved;
	}

	@Override
	public void deleteCustomer(int customerId,String key) throws CustomerException,LoginException {
		// TODO Auto-generated method stub
		Customer customer = customerRepo.findById(customerId)
				.orElseThrow(() -> new CustomerException("No customer found with id: " + customerId));
		customerRepo.delete(customer);
	}

	@Override
	public Customer viewCustomer(int customerId,String key) throws CustomerException {
		return customerRepo.findById(customerId)
				.orElseThrow(() -> new CustomerException("No customer found with id: " + customerId));
	}

	@Override
	public List<Customer> viewAllCustomers() throws CustomerException {
		// TODO Auto-generated method stub
		List<Customer> customers = customerRepo.findAll();
		if (customers.isEmpty()) {
			throw new CustomerException("No customers found in the system");
		}
		return customers;
	}

	@Override
	public Customer validateCustomer(String mobileNumber, String password) throws CustomerException {
		  Customer customer = customerRepo.findByCustomerMobileNumber(mobileNumber);
	        if (customer == null) {
	            throw new CustomerException("No customer found with mobileNumber: " + mobileNumber);
	        }
	        if (!customer.getCustomerPassword().equals(password)) {
	            throw new CustomerException("Incorrect password for customer with mobileNumber: " + mobileNumber);
	        }
	        return customer;
	    }
	}


