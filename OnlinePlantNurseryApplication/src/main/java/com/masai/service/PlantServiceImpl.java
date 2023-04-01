package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.masai.exception.LoginException;
import com.masai.exception.PlantException;
import com.masai.model.AdminSession;
import com.masai.model.CustomerSession;
import com.masai.model.Plant;
import com.masai.repository.AdminSessionRepository;
import com.masai.repository.CustomerSessionRepository;
import com.masai.repository.PlantPaginationRepo;
import com.masai.repository.PlantRepository;


@Service
public class PlantServiceImpl implements PlantService{
	@Autowired
	private PlantRepository plantrepo;

	@Autowired
	private AdminSessionRepository adminSessionRepository;
	
	@Autowired
	private CustomerSessionRepository customerSessionRepository;
	
	@Autowired
	private PlantPaginationRepo plantPaginationRepo;
	
	
	@Override
	public Plant addPlant(Plant plant,String key)throws LoginException {
		// TODO Auto-generated method stub
		AdminSession adminSession = adminSessionRepository.findByUuid(key);
        if(adminSession == null) throw new LoginException("Key is not valid login again.");
        
		Plant p1 = plantrepo.save(plant);
		return p1;
	}

	@Override
	public Plant updatePlant(Plant plant,String key) throws PlantException,LoginException {
		// TODO Auto-generated method stub
		AdminSession adminSession = adminSessionRepository.findByUuid(key);
        if(adminSession == null) throw new LoginException("Key is not valid login again.");
        
		Optional<Plant> p1 = plantrepo.findById(plant.getPlantId());
		if(p1.isEmpty())throw new PlantException("Plant not fount with given plantID: "+plant.getPlantId());
		else {
			Plant p2 = p1.get();
			p2.setPlantId(plant.getPlantId());
			p2.setPlantHeight(plant.getPlantHeight());
			p2.setPlantSpread(plant.getPlantSpread());
			p2.setBloomTime(plant.getBloomTime());
			p2.setPlantCommonName(plant.getPlantCommonName());
			p2.setMedicinalCulinaryUse(plant.getMedicinalCulinaryUse());
			p2.setDifficultyLevel(plant.getDifficultyLevel());
			p2.setTemparature(plant.getTemparature());
			p2.setTypeOfPlant(plant.getTypeOfPlant());
			p2.setPlantDescription(plant.getPlantDescription());
			p2.setPlantStock(plant.getPlantStock());
			p2.setPlantCost(plant.getPlantCost());
			p2.setUrl(plant.getUrl());
			
			
			plantrepo.save(p2);
			
			
			return p2;
		}
		
	}

	@Override
	public Plant deletePlant(Integer PlantId,String key) throws PlantException,LoginException {
		// TODO Auto-generated method stub
		AdminSession adminSession = adminSessionRepository.findByUuid(key);
        if(adminSession == null) throw new LoginException("Key is not valid login again.");
        
		Optional<Plant> p1 = plantrepo.findById(PlantId);
		if(p1.isEmpty())throw new PlantException("Plant not found with given plantID: "+PlantId);
		else {
			Plant p2 = p1.get();
			plantrepo.delete(p2);
			return p2;
		}
		
	}

	@Override
	public Plant viewPlant(int plantId,String key) throws PlantException,LoginException {
		
		AdminSession adminSession = adminSessionRepository.findByUuid(key);
		CustomerSession customerSession = customerSessionRepository.findByUuid(key);
        if(adminSession == null && customerSession==null) throw new LoginException("Key is not valid login again.");
        
		Optional<Plant> p1 = plantrepo.findById(plantId);
		if(p1.isEmpty())throw new PlantException("Plant not fount with given plantID: "+plantId);
		else {
			Plant p2 = p1.get();
			return p2;
		}
	}

	@Override
	public Plant viewPlant(String commonName,String key) throws PlantException,LoginException {
		
		AdminSession adminSession = adminSessionRepository.findByUuid(key);
		CustomerSession customerSession = customerSessionRepository.findByUuid(key);
        if(adminSession == null && customerSession==null) throw new LoginException("Key is not valid login again.");
        
		Plant p1 = plantrepo.findByplantCommonName(commonName);
		if(p1 == null)throw new PlantException("Plant not fount with given commonName: "+commonName);
		else {
			return p1;
		}
	}

	@Override
	public List<Plant> viewAllPlants(String key) throws PlantException ,LoginException{
		
		AdminSession adminSession = adminSessionRepository.findByUuid(key);
		CustomerSession customerSession = customerSessionRepository.findByUuid(key);
        if(adminSession == null && customerSession==null) throw new LoginException("Key is not valid login again.");
        
		// TODO Auto-generated method stub
		List<Plant> pl = plantrepo.findAll();
		if(pl.isEmpty()) throw new PlantException("No Plant Exist");
		else
		return pl;
	}

	@Override
	public List<Plant> viewAllPlants(String typeOfPlant,String key) throws PlantException ,LoginException{
		
		AdminSession adminSession = adminSessionRepository.findByUuid(key);
		CustomerSession customerSession = customerSessionRepository.findByUuid(key);
        if(adminSession == null && customerSession==null) throw new LoginException("Key is not valid login again.");
        
		List<Plant> pl = plantrepo.findBytypeOfPlant(typeOfPlant);
		if(pl.isEmpty()) throw new PlantException("No Plant Exist with the given typeOfPlant: "+typeOfPlant);
		else
		return pl;
	}

	@Override
	public List<Plant> getListByPagination(Integer pageNo) throws PlantException{
		

        Pageable firstPageWithTwoElements =  PageRequest.of(pageNo, 30);

        
		Page<Plant> pl = plantPaginationRepo.findAll(firstPageWithTwoElements);
		if(pl.isEmpty()) throw new PlantException("No Plant Exist");
		else
		return pl.getContent();
        
	}

	
	// Ayaz Khan
}
