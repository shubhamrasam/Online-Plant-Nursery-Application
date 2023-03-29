package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.OrderException;
import com.masai.exception.SeedException;
import com.masai.model.Orders;
import com.masai.model.Seed;
import com.masai.repository.OrdersRepository;
import com.masai.repository.SeedRepository;

@Service
public class SeedServiceImpl implements SeedService{

	@Autowired
	private SeedRepository seedRepository;
	
	@Override
	public Seed addSeed(Seed seed) throws SeedException {
		
	    Optional<Seed> optSeed = seedRepository.findById(seed.getSeedid());
		
		if(optSeed.isEmpty()) {
			
			return seedRepository.save(seed);
		}
		
		throw new SeedException("Seed already present with id: "+seed.getSeedid());
		
	}

	@Override
	public Seed updateSeed(Seed seed) throws SeedException {
		
		Optional<Seed> optSeed = seedRepository.findById(seed.getSeedid());
		
		if(optSeed.isEmpty()) {
			
			throw new SeedException("Seed is not present with id: "+seed.getSeedid());
			
		}
		
		return seedRepository.save(seed);
		
	
	}

	@Override
	public Seed deleteSeed(Integer seedId) throws SeedException {

		Optional<Seed> optSeed =  seedRepository.findById(seedId);
		
		if(optSeed.isEmpty()) {
			
			throw new SeedException("Seed is not present with id: "+seedId);
			
		}
		
		seedRepository.delete(optSeed.get());
		
		Seed seed = optSeed.get();
		
		return seed;
		
	}

	@Override
	public Seed viewSeed(Integer seedId) throws SeedException {
		
		Optional<Seed> optSeed =  seedRepository.findById(seedId);
		
		if(optSeed.isEmpty()) {
			
			throw new SeedException("Seed is not present with id: "+seedId);
			
		}
		
		return optSeed.get();
	}

	@Override
	public Seed viewSeed(String commonName) throws SeedException {
		
		Seed seed = seedRepository.findByCommonName(commonName);
		
		if(seed == null) {
			
			throw new SeedException("Seed is not present with common Name: "+commonName);
			
		}
		
		return seed;
	}

	@Override
	public List<Seed> viewAllSeeds() throws SeedException {
		
		List<Seed> seeds = seedRepository.findAll();
		
		if(seeds.isEmpty()) {
			
			throw new SeedException("Seeds are not present.");
			
		}
		
		return seeds;
	}

	@Override
	public List<Seed> viewAllSeeds(String typeOfSeed) throws SeedException {
	    
		List<Seed> seeds = seedRepository.findByTypeOfSeeds(typeOfSeed);
		
		if(seeds.isEmpty()) {
			
			throw new SeedException(typeOfSeed+" types of seeds not available");
			
		}
		
		return seeds;
		
	}

	
}
