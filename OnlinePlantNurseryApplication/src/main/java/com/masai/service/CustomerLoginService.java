package com.masai.service;

import com.masai.exception.LoginException;
import com.masai.model.CustomerLoginDTO;

public interface CustomerLoginService {

	public String logIntoAccount(CustomerLoginDTO dto) throws LoginException;
	public String logOutAccount(String key) throws LoginException;
	
}
