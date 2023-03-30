package com.masai.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.model.Plant;

@Repository
public interface PlantRepository extends JpaRepository<Plant, Integer> {

	// ayaz khan
	
	public Plant findByplantCommonName(String commonName);
	public List<Plant> findBytypeOfPlant(String typeOfPlant);
	
}
