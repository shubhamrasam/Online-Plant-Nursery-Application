package com.masai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.AdminException;
import com.masai.model.Admin;
import com.masai.repository.AdminRepository;
@Service
public class AdminServiceImpl implements AdminService {
	@Autowired
	private AdminRepository adminRepo;

	@Override
	public Admin addAdmin(Admin admin) throws AdminException {
		Admin existingAdmin=adminRepo.findByAdminMobileNumber(admin.getAdminMobileNumber());
		if(existingAdmin!=null) {
			throw new AdminException("Admin Already Registered with mobile no");
		}
		return adminRepo.save(admin);
	}

}
