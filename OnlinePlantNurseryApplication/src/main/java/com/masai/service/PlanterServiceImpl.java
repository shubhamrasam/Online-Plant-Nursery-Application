package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.LoginException;
import com.masai.exception.PlanterException;
import com.masai.model.AdminSession;
import com.masai.model.CustomerSession;
import com.masai.model.Plant;
import com.masai.model.Planter;
import com.masai.model.Seed;
import com.masai.repository.AdminSessionRepository;
import com.masai.repository.CustomerSessionRepository;
import com.masai.repository.PlantRepository;
import com.masai.repository.PlanterRepository;
import com.masai.repository.SeedRepository;

@Service
public class PlanterServiceImpl implements PlanterService{
    
	@Autowired
	PlanterRepository planterRepo;
	
	@Autowired
	PlantRepository plantRepo;
	
	@Autowired
	SeedRepository seedRepo;
	
	@Autowired
	private AdminSessionRepository adminSessionRepository;
	
	@Autowired
	private CustomerSessionRepository customerSessionRepository;
	
	@Override
	public Planter addPlanter(Planter planter,Integer plantId,Integer seedId, String key) throws LoginException{
		// TODO Auto-generated method stub
		AdminSession adminSession = adminSessionRepository.findByUuid(key);
        if(adminSession == null) throw new LoginException("Key is not valid login again.");
        
        if(plantId!=null) {
        	 Plant plant = plantRepo.findById(plantId).get();
        	 planter.setPlant(plant);
        }
        
        if(seedId!=null) {
        	Seed seed= seedRepo.findById(seedId).get();
        	planter.setSeed(seed);
        }
        	
		Planter p1 = planterRepo.save(planter);
        
		return p1;
	}

	@Override
	public Planter updatePlanter(Planter planter, String key) throws PlanterException ,LoginException{
		// TODO Auto-generated method stub
		AdminSession adminSession = adminSessionRepository.findByUuid(key);
        if(adminSession == null) throw new LoginException("Key is not valid login again.");
        
		Optional<Planter> p1 = planterRepo.findById(planter.getPlanterid());
		if(p1.isEmpty()) throw new PlanterException("No Planter Found with the given planterId: "+planter.getPlanterid());
		else {
			
			planterRepo.save(p1.get());
			
			return p1.get();
		}
		
		
	}

	@Override
	public Planter deletePlanter(Planter planter, String key) throws PlanterException,LoginException {
		// TODO Auto-generated method stub
		AdminSession adminSession = adminSessionRepository.findByUuid(key);
        if(adminSession == null) throw new LoginException("Key is not valid login again.");
        
		Optional<Planter> p1 = planterRepo.findById(planter.getPlanterid());
		if(p1.isEmpty()) throw new PlanterException("No Planter Found with the given planterId: "+planter.getPlanterid());
		else {
			Planter p2 = p1.get();
			planterRepo.delete(p2);
			return p2;
		}
		
	}

	@Override
	public Planter viewPlanter(int planterId ,String key) throws PlanterException ,LoginException{
		// TODO Auto-generated method stub
		AdminSession adminSession = adminSessionRepository.findByUuid(key);
		CustomerSession customerSession = customerSessionRepository.findByUuid(key);
        if(adminSession == null && customerSession==null) throw new LoginException("Key is not valid login again.");
        
		Optional<Planter> p1  = planterRepo.findById(planterId);
		if(p1.isEmpty()) throw new PlanterException("No Planter Found with the given id: "+planterId);
		else {
			Planter p2 = p1.get();
			return p2;
		}
	}

	@Override
	public Planter viewPlanter(String planterShape, String key) throws PlanterException,LoginException {
		// TODO Auto-generated method stub
		AdminSession adminSession = adminSessionRepository.findByUuid(key);
		CustomerSession customerSession = customerSessionRepository.findByUuid(key);
        if(adminSession == null && customerSession==null) throw new LoginException("Key is not valid login again.");
        
		Planter p1  = planterRepo.findByPlanterShape(planterShape);
		if(p1 == null) throw new PlanterException("No Planter Found with the given planterShape: "+planterShape);
		else
		return p1;
	}

	@Override
	public List<Planter> viewAllPlanters(String key) throws PlanterException,LoginException {
		// TODO Auto-generated method stub
		AdminSession adminSession = adminSessionRepository.findByUuid(key);
		CustomerSession customerSession = customerSessionRepository.findByUuid(key);
        if(adminSession == null && customerSession==null) throw new LoginException("Key is not valid login again.");
        
		List<Planter> pl = planterRepo.findAll();
		if(pl.isEmpty()) throw new PlanterException("No Planter Exist");
		else
		return pl;
	}

	@Override
	public List<Planter> viewAllPlanters(double minCost, double maxCost, String key) throws PlanterException ,LoginException{
		// TODO Auto-generated method stub
		AdminSession adminSession = adminSessionRepository.findByUuid(key);
		CustomerSession customerSession = customerSessionRepository.findByUuid(key);
        if(adminSession == null && customerSession==null) throw new LoginException("Key is not valid login again.");
        
		List<Planter> pl = planterRepo.findByPlanterCostBetween(minCost, maxCost);
		if(pl.isEmpty()) throw new PlanterException("No Planter Exist witnin the given range between "+minCost+" and "+maxCost);
		else
		return pl;
	}



	// Ayaz Khan
	
}
