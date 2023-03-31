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
import com.masai.repository.PlanterRepository;

@Service
public class PlanterServiceImpl implements PlanterService{
    
	@Autowired
	PlanterRepository planterRepo;
	
	@Autowired
	private AdminSessionRepository adminSessionRepository;
	
	@Autowired
	private CustomerSessionRepository customerSessionRepository;
	
	@Override
	public Planter addPlanter(Planter planter, String key) throws LoginException{
		// TODO Auto-generated method stub
		AdminSession adminSession = adminSessionRepository.findByUuid(key);
        if(adminSession == null) throw new LoginException("Key is not valid login again.");
          
		Planter p1 = planterRepo.save(planter);
		return p1;
	}

	@Override
	public Planter updatePlanter(Planter planter, String key) throws PlanterException ,LoginException{
		// TODO Auto-generated method stub
		AdminSession adminSession = adminSessionRepository.findByUuid(key);
        if(adminSession == null) throw new LoginException("Key is not valid login again.");
        
		Optional<Planter> p1 = planterRepo.findById(planter.getPlanterid());
		if(p1.isEmpty()) throw new PlanterException("No Planter Found");
		else {
			Planter p2 = p1.get();
			p2.setPlanterid(planter.getPlanterid());
			p2.setPlanterheight(planter.getPlanterheight());
			p2.setPlanterCapacity(planter.getPlanterCapacity());
			p2.setDrinageHoles(planter.getDrinageHoles());
			p2.setPlanterColor(planter.getPlanterColor());
			p2.setPlanterShape(planter.getPlanterShape());
			p2.setPlanterStock(planter.getPlanterStock());
			p2.setPlanterCost(planter.getPlanterCost());
//			p2.setPlant(planter.getPlant());
//			p2.setSeed(planter.getSeed());
			
			planterRepo.save(p2);
			
			return p2;
		}
		
		
	}

	@Override
	public Planter deletePlanter(Planter planter, String key) throws PlanterException,LoginException {
		// TODO Auto-generated method stub
		AdminSession adminSession = adminSessionRepository.findByUuid(key);
        if(adminSession == null) throw new LoginException("Key is not valid login again.");
        
		Optional<Planter> p1 = planterRepo.findById(planter.getPlanterid());
		if(p1.isEmpty()) throw new PlanterException("No Planter Found");
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
		if(p1.isEmpty()) throw new PlanterException("No Planter Found with the given id");
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
		if(p1 == null) throw new PlanterException("No Planter Found with the given planterShape");
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
		if(pl.isEmpty()) throw new PlanterException("No Planter Exist witnin the given range");
		else
		return pl;
	}



	// Ayaz Khan
	
}
