package com.masai.service;

import java.util.List;

import com.masai.exception.LoginException;
import com.masai.exception.PlantException;
import com.masai.exception.SeedException;
import com.masai.model.Plant;
import com.masai.model.Seed;

public interface SeedService {

	public Seed addSeed(Seed seed , String key) throws SeedException,LoginException;
	
	public Seed updateSeed(Seed seed, String key) throws SeedException,LoginException;
	
	public Seed deleteSeed(Integer seedId , String key) throws SeedException,LoginException;
	
	public Seed viewSeed(Integer seedId, String key) throws SeedException,LoginException;
	
	public Seed viewSeed(String commonName , String key) throws SeedException,LoginException;
	
	public List<Seed> viewAllSeeds(String key) throws SeedException,LoginException;
	
	public List<Seed> viewAllSeeds(String typeOfSeed , String key) throws SeedException,LoginException;
	
	public List<Seed> getListByPagination(Integer pageNo)throws SeedException;
	
}
