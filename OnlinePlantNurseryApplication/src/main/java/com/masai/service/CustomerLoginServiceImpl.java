package com.masai.service;

import org.springframework.stereotype.Service;

import com.masai.exception.LoginException;
import com.masai.model.CustomerLoginDTO;

@Service
public class CustomerLoginServiceImpl implements CustomerLoginService {

	//Ashish Kumar
	
	@Override
	public String logIntoAccount(CustomerLoginDTO dto) throws LoginException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String logOutAccount(String key) throws LoginException {
		// TODO Auto-generated method stub
		return null;
	}

}
