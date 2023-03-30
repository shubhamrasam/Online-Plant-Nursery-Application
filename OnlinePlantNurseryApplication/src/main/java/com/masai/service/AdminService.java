package com.masai.service;

import com.masai.exception.AdminException;
import com.masai.model.Admin;

public interface AdminService {
	
	public Admin addAdmin(Admin admin) throws AdminException;

}
