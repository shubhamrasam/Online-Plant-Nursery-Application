package com.masai.service;

import java.util.List;

import com.masai.exception.CustomerException;
import com.masai.exception.LoginException;
import com.masai.model.Customer;

public interface CustomerService {
	
	
	public Customer addCustomer(Customer customer) throws CustomerException;


    public Customer updateCustomer(Integer customerId,Customer customer,String key) throws CustomerException,LoginException;

    public String deleteCustomer(int customerId,String key) throws CustomerException,LoginException;

    public Customer viewCustomer(int customerId,String key) throws CustomerException,LoginException;

    public List<Customer> viewAllCustomers() throws CustomerException;

    public String validateCustomer(String mobileNumber, String password) throws CustomerException;

	
}
