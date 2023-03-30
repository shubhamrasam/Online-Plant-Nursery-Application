package com.masai.service;

import java.util.List;

import com.masai.exception.LoginException;
import com.masai.exception.PlantException;
import com.masai.model.Plant;

public interface PlantService {
    
	 public Plant addPlant(Plant plant, String key)throws LoginException;  
	 public Plant updatePlant(Plant plant, String key)throws PlantException,LoginException; 
	 public Plant deletePlant(Plant plant, String key)throws PlantException,LoginException;
	 public Plant viewPlant(int plantId, String key)throws PlantException,LoginException;
	 public Plant viewPlant(String commonName, String key)throws PlantException,LoginException;
	 public List<Plant>  viewAllPlants(String key)throws PlantException,LoginException;
	 public List<Plant> viewAllPlants(String typeOfPlant, String key)throws PlantException,LoginException;
}
