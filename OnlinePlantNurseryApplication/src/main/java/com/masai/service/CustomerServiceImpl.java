package com.masai.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.CustomerException;
import com.masai.exception.LoginException;
import com.masai.model.AdminSession;
import com.masai.model.Customer;
import com.masai.model.CustomerSession;
import com.masai.repository.CustomerRepository;
import com.masai.repository.CustomerSessionRepository;

import net.bytebuddy.utility.RandomString;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepo;

	@Autowired
	private CustomerSessionRepository customerSessionRepo;

	@Override
	public Customer addCustomer(Customer customer) throws CustomerException, LoginException {
		Customer existingCustomer = customerRepo.findByCustomerMobileNumber(customer.getCustomerMobileNumber());
		if (existingCustomer != null) {
			throw new CustomerException("Customer Already Register with mobile no");
		}

		return customerRepo.save(customer);
	}

	@Override
	public Customer updateCustomer(Integer customerId, Customer customer, String key)
			throws CustomerException, LoginException {

		CustomerSession cus = customerSessionRepo.findByUuid(key);

		if (cus == null)
			throw new LoginException("customer not logged in");

		Customer savedC = customerRepo.findById(customerId).orElseThrow(() -> new CustomerException(
				"There is no customer for update with thid id " + customer.getCustomerId()));

		if (customer.getCustomerMobileNumber() != null) {
			savedC.setCustomerMobileNumber(customer.getCustomerMobileNumber());
		}
		if (customer.getUserEmail() != null) {
			savedC.setUserEmail(customer.getUserEmail());
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
	public String deleteCustomer(int customerId, String key) throws CustomerException, LoginException {
		// TODO Auto-generated method stub
		CustomerSession cus = customerSessionRepo.findByUuid(key);

		if (cus == null)
			throw new LoginException("customer not logged in");
		
		Customer customer = customerRepo.findById(customerId)
				.orElseThrow(() -> new CustomerException("No customer found with id: " + customerId));
		
		customerRepo.delete(customer);
		
		return "delete successfully";
	}

	@Override
	public Customer viewCustomer(int customerId, String key) throws CustomerException {
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
	public String validateCustomer(String mobileNumber, String password) throws CustomerException {
		Customer customer = customerRepo.findByCustomerMobileNumber(mobileNumber);
		if (customer == null) {
			throw new CustomerException("No customer found with mobileNumber: " + mobileNumber);
		}
		if (customer.getCustomerPassword().equals(password)) {

			String key = RandomString.make(6);

			CustomerSession customerSes = new CustomerSession();

			customerSes.setCustomerId(customer.getCustomerId());
			customerSes.setUuid(key);
			customerSes.setLocalDateTime(LocalDateTime.now());

			customerSessionRepo.save(customerSes);

			return customerSes.toString();
		} else {
			throw new LoginException("Invalid Pasword please give correct credential");
		}

	}
}
