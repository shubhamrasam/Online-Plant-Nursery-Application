package com.masai.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.masai.model.Plant;

@Repository
public interface PlantRepository extends JpaRepository<Plant, Integer> {

	// ayaz khan
	
	public Plant findByplantCommonName(String commonName);
	public List<Plant> findBytypeOfPlant(String typeOfPlant);
	
//	
//	@Query("From Plant limit 30 offset ?1")
//	public List<Plant> getPage1(Integer start);
}
