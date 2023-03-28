package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.model.AdminSession;

public interface AdminSessionRepository extends JpaRepository<AdminSession, Integer> {

	// ashish kumar
	public AdminSession findByUuid(String key);
	
}
