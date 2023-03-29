package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.masai.model.Seed;

@Repository
public interface SeedRepository extends JpaRepository<Seed, Integer>{

	// shubham rasam
	
}
