package com.masai.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.masai.model.Planter;

public interface PlanterRepository extends JpaRepository<Planter, Integer> {


	// ayaz khan
	public Planter findByplanterShape(String planterShape);
	public List<Planter> findByBetweenplanterCost(double minCost, double maxCost);
	
}
