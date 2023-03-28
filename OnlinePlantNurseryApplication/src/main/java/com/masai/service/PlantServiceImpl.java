package com.masai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.repository.PlanterRepository;

@Service
public class PlantServiceImpl implements PlantService{
	@Autowired
	private PlanterRepository plantrepo;

	// Ayaz Khan
}
