package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.LoginException;
import com.masai.exception.SeedException;
import com.masai.model.AdminSession;
import com.masai.model.CustomerSession;
import com.masai.model.Planter;
import com.masai.model.Seed;
import com.masai.repository.AdminSessionRepository;
import com.masai.repository.CustomerSessionRepository;
import com.masai.repository.SeedRepository;

@Service
public class SeedServiceImpl implements SeedService{

	@Autowired
	private SeedRepository seedRepository;
	
	@Autowired
	private AdminSessionRepository adminSessionRepository;
	
	@Autowired
	private CustomerSessionRepository customerSessionRepository;
	
	@Override
	public Seed addSeed(Seed seed, String key) throws SeedException,LoginException {
		
        AdminSession adminSession = adminSessionRepository.findByUuid(key);
        
        if(adminSession == null) throw new LoginException("Key is not valid login again.");
	
       Seed seed1 =  seedRepository.save(seed);
		
		return seed1;
		
	}

	@Override
	public Seed updateSeed(Seed seed, String key) throws SeedException,LoginException {
		
        AdminSession adminSession = adminSessionRepository.findByUuid(key);
        
        if(adminSession == null) throw new LoginException("Key is not valid login again.");
		
		Optional<Seed> optSeed = seedRepository.findById(seed.getSeedid());
		
		if(optSeed.isEmpty()) {
			
			throw new SeedException("Seed is not present with id: "+seed.getSeedid());
			
		}
		
		return seedRepository.save(seed);
	}

	@Override
	public Seed deleteSeed(Integer seedId, String key) throws SeedException,LoginException {
		
        AdminSession adminSession = adminSessionRepository.findByUuid(key);
        
        if(adminSession == null) throw new LoginException("Key is not valid login again.");

		Optional<Seed> optSeed =  seedRepository.findById(seedId);
		
		if(optSeed.isEmpty()) {
			
			throw new SeedException("Seed is not present with id: "+seedId);
			
		}
		
		seedRepository.delete(optSeed.get());
		
		Seed seed = optSeed.get();
		
		return seed;
	}

	@Override
	public Seed viewSeed(Integer seedId, String key) throws SeedException,LoginException {
		
		AdminSession adminSession = adminSessionRepository.findByUuid(key);
		
		CustomerSession customerSession = customerSessionRepository.findByUuid(key);
	        
	    if(adminSession == null && customerSession == null) throw new LoginException("Key is not valid login again.");
		
		Optional<Seed> optSeed =  seedRepository.findById(seedId);
		
		if(optSeed.isEmpty()) {
			
			throw new SeedException("Seed is not present with id: "+seedId);
			
		}

		return optSeed.get();
	}

	@Override
	public Seed viewSeed(String commonName, String key) throws SeedException,LoginException {
		
		AdminSession adminSession = adminSessionRepository.findByUuid(key);
		
		CustomerSession customerSession = customerSessionRepository.findByUuid(key);
	        
	    if(adminSession == null && customerSession == null) throw new LoginException("Key is not valid login again.");
		
		Seed seed = seedRepository.findByCommonName(commonName);
		
		if(seed == null) {
			
			throw new SeedException("Seed is not present with common Name: "+commonName);
			
		}
		
		return seed;
	}

	@Override
	public List<Seed> viewAllSeeds(String key) throws SeedException,LoginException {
		
		AdminSession adminSession = adminSessionRepository.findByUuid(key);
		
		CustomerSession customerSession = customerSessionRepository.findByUuid(key);
	        
	    if(adminSession == null && customerSession == null) throw new LoginException("Key is not valid login again.");
		
		List<Seed> seeds = seedRepository.findAll();
		
		if(seeds.isEmpty()) {
			
			throw new SeedException("Seeds are not present.");
			
		}
		
		return seeds;
	}

	@Override
	public List<Seed> viewAllSeeds(String typeOfSeed, String key) throws SeedException,LoginException {
		
		AdminSession adminSession = adminSessionRepository.findByUuid(key);
		
		CustomerSession customerSession = customerSessionRepository.findByUuid(key);
	        
	    if(adminSession == null && customerSession == null) throw new LoginException("Key is not valid login again.");
	    
		List<Seed> seeds = seedRepository.findByTypeOfSeeds(typeOfSeed);
		
		if(seeds.isEmpty()) {
			
			throw new SeedException(typeOfSeed+" types of seeds not available");
			
		}
		
		return seeds;
		
	}

	
}
