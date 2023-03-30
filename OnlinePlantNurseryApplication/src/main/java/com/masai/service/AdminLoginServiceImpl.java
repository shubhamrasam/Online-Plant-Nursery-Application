package com.masai.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.LoginException;
import com.masai.model.Admin;
import com.masai.model.AdminLoginDTO;
import com.masai.model.AdminSession;
import com.masai.repository.AdminRepository;
import com.masai.repository.AdminSessionRepository;

import net.bytebuddy.utility.RandomString;

@Service
public class AdminLoginServiceImpl implements AdminLoginService {

	// Ashish Kumar
	@Autowired
	private AdminRepository adminrepo;
	@Autowired
	private AdminSessionRepository adminsessionRepo;

	@Override
	public String logIntoAccount(AdminLoginDTO dto) throws LoginException {
		
		Admin existingAdmin = adminrepo.findByAdminMobileNumber(dto.getAdminMobileNumber());
		
		if (existingAdmin == null)
			
			throw new LoginException("please Enter valid mobile no");
		
		Optional<AdminSession> validsession = adminsessionRepo.findById(existingAdmin.getAdminId());
		
		if (validsession.isPresent()) {
			
			System.out.println(validsession);
			
			throw new LoginException("Admin Already Login with this no");
		}
		if (existingAdmin.getAdminPassword().equals(dto.getAdminPassword())) {
			
			String key = RandomString.make(6);
			
			AdminSession currentAdminSession = new AdminSession(existingAdmin.getAdminId(), key, LocalDateTime.now());
			
			adminsessionRepo.save(currentAdminSession);
			return currentAdminSession.toString();
		} else {
			throw new LoginException("Invalid Pasword please give correct credential");
		}

	}

	@Override
	public String logOutAccount(String key) throws LoginException {
		AdminSession validAdminSession = adminsessionRepo.findByUuid(key);
		if (validAdminSession == null) {
			throw new LoginException("Admin not logged in with this number");
		} else {
			adminsessionRepo.delete(validAdminSession);
			return "Admin Logged out Sucessfully";
		}
	}

}
