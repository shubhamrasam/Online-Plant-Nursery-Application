package com.masai.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.LoginException;
import com.masai.model.Customer;
import com.masai.model.CustomerLoginDTO;
import com.masai.model.CustomerSession;
import com.masai.repository.CustomerRepository;
import com.masai.repository.CustomerSessionRepository;

import net.bytebuddy.utility.RandomString;

@Service
public class CustomerLoginServiceImpl implements CustomerLoginService {

	//Ashish Kumar
	@Autowired
	private CustomerRepository customerRepo;
	@Autowired
	private CustomerSessionRepository custSession;
	
	@Override
	public String logIntoAccount(CustomerLoginDTO dto) throws LoginException {
		Customer existingCustomer=customerRepo.findByCustomerMobileNumber(dto.getCustomerMobileNumber());
		if(existingCustomer==null) throw new LoginException("Please Enter A valid Mobile No");
		Optional<CustomerSession> validCustomersession=custSession.findById(existingCustomer.getCustomerId());
		if(validCustomersession.isPresent()) {
			System.out.println(validCustomersession);
			throw new LoginException("Customer Already loging with this Number");
		}
		if(existingCustomer.getCustomerPassword().equals(dto.getCustomerPassword())) {
			String key=RandomString.make(6);
			CustomerSession currentCustomerSession=new CustomerSession(existingCustomer.getCustomerId(),key,LocalDateTime.now());
			custSession.save(currentCustomerSession);
			return currentCustomerSession.toString();
		}else {
			throw new LoginException("invalid Customer password please login again");
		}
		
	}

	@Override
	public String logOutAccount(String key) throws LoginException {
		CustomerSession validCustomerSession=custSession.findByUuid(key);
		if(validCustomerSession==null)throw new LoginException("customer not logged In with this no");
		custSession.delete(validCustomerSession);;
		return "Customer Sucessfully logged out";
	}

}
