package com.masai.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.model.Planter;

@Repository
public interface PlanterRepository extends JpaRepository<Planter, Integer> {


	// ayaz khan

	public Planter findByPlanterShape(String planterShape);
	public List<Planter> findByPlanterCostBetween(double minCost, double maxCost);

	
}
