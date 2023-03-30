package com.masai.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.model.Planter;

@Repository
public interface PlanterRepository extends JpaRepository<Planter, Integer> {


	// ayaz khan
<<<<<<< HEAD
	public Planter findByplanterShape(String planterShape);
	public List<Planter> findByBetweenplanterCost(double minCost, double maxCost);
=======
	public Planter findByPlanterShape(String planterShape);
	public List<Planter> findByPlanterCostBetween(double minCost, double maxCost);
>>>>>>> 746a73e871b750731d0c1a6d04b37305c7a80515
	
}
