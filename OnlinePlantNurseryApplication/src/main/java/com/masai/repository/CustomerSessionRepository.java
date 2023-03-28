package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.model.CustomerSession;

public interface CustomerSessionRepository extends JpaRepository<CustomerSession, Integer> {

	// ashish kumar
	public CustomerSession  findByUuid(String key);
	
}
