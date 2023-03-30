package com.masai.service;

import java.util.List;

import com.masai.exception.SeedException;
import com.masai.model.Seed;

public interface SeedService {

	public Seed addSeed(Seed seed) throws SeedException;
	
	public Seed updateSeed(Seed seed) throws SeedException;
	
	public Seed deleteSeed(Integer seedId) throws SeedException;
	
	public Seed viewSeed(Integer seedId) throws SeedException;
	
	public Seed viewSeed(String commonName) throws SeedException;
	
	public List<Seed> viewAllSeeds() throws SeedException;
	
	public List<Seed> viewAllSeeds(String typeOfSeed) throws SeedException;
	
	
}
