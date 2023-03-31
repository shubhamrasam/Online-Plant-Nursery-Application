package com.masai.service;

import java.util.List;

import com.masai.exception.LoginException;
import com.masai.exception.PlanterException;
import com.masai.model.Planter;

public interface PlanterService {
	
	 public Planter addPlanter(Planter planter,Integer plantId,Integer seedId, String key)throws LoginException;
	 public Planter updatePlanter(Planter planter, String key)throws PlanterException ,LoginException;
	 public Planter deletePlanter(Planter planter, String key)throws PlanterException ,LoginException;
	 public Planter viewPlanter(int planterId, String key)throws PlanterException,LoginException; 
	 public Planter viewPlanter(String planterShape, String key)throws PlanterException,LoginException; 
	 public List<Planter>  viewAllPlanters(String key)throws PlanterException,LoginException;
	 public List<Planter>  viewAllPlanters(double minCost ,double maxCost, String key)throws PlanterException,LoginException;
 
}
