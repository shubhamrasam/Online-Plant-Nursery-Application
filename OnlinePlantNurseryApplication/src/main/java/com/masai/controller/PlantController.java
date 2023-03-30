package com.masai.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.Plant;
import com.masai.service.PlantService;

@RestController
public class PlantController {

	@Autowired
	PlantService plantservice;
	
	@PostMapping("/plants/add")
	public ResponseEntity<Plant> addPlant(@RequestBody Plant plant) {
		Plant plant1 = plantservice.addPlant(plant);
		return new ResponseEntity<>(plant1,HttpStatus.OK);
	}
	
	@PutMapping("/plants/update")
	public ResponseEntity<Plant> updatePlant(@RequestBody Plant plant) {
		// TODO Auto-generated method stub
		Plant plant1 = plantservice.updatePlant(plant);
		return new ResponseEntity<>(plant1,HttpStatus.OK);
		
	}

	@DeleteMapping("/plants/delete")
	public ResponseEntity<Plant> deletePlant(@RequestBody Plant  plant){
		// TODO Auto-generated method stub
		Plant plant1 = plantservice.deletePlant(plant);
		return new ResponseEntity<>(plant1,HttpStatus.OK);
	}

	@GetMapping("/plants/getbyId/{plantId}")
	public ResponseEntity<Plant> viewPlant(@PathVariable int plantId){
		Plant plant1 = plantservice.viewPlant(plantId);
		return new ResponseEntity<>(plant1,HttpStatus.OK);
	}

	@GetMapping("/plants/getbycommonName/{commonName}")
	public ResponseEntity<Plant> viewPlant(@PathVariable String commonName){
		Plant plant1 = plantservice.viewPlant(commonName);
		return new ResponseEntity<>(plant1,HttpStatus.OK);
	}

	@GetMapping("/plants/getall")
	public ResponseEntity<List<Plant>> viewAllPlants() {
		List<Plant> plant1 = plantservice.viewAllPlants();
		return new ResponseEntity<>(plant1,HttpStatus.OK);
	}

	@GetMapping("/plants/getallbytype/{typeOfPlant}")
	public ResponseEntity<List<Plant>> viewAllPlants(@PathVariable String typeOfPlant){
		List<Plant> plant1 = plantservice.viewAllPlants(typeOfPlant);
		return new ResponseEntity<>(plant1,HttpStatus.OK);
	}

}
