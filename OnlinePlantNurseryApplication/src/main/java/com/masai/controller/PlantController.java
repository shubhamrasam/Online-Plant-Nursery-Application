package com.masai.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.Plant;
import com.masai.service.PlantService;

@CrossOrigin(origins="*")
@RestController
public class PlantController {

	@Autowired
	PlantService plantservice;
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/plants/add")
	public ResponseEntity<Plant> addPlant(@RequestBody Plant plant,@RequestParam(name="key") String key) {
		Plant plant1 = plantservice.addPlant(plant,key);
		return new ResponseEntity<>(plant1,HttpStatus.OK);
	}
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/plants/update")
	public ResponseEntity<Plant> updatePlant(@RequestBody Plant plant,@RequestParam(name="key") String key) {
		// TODO Auto-generated method stub
		Plant plant1 = plantservice.updatePlant(plant,key);
		return new ResponseEntity<>(plant1,HttpStatus.OK);
		
	}

	@DeleteMapping("/plants/delete/{PlantId}")
	public ResponseEntity<Plant> deletePlant(@PathVariable Integer PlantId,@RequestParam(name="key") String key){
		// TODO Auto-generated method stub
		Plant plant1 = plantservice.deletePlant(PlantId,key);
		return new ResponseEntity<>(plant1,HttpStatus.OK);
	}

	@GetMapping("/plants/getbyId/{plantId}")
	public ResponseEntity<Plant> viewPlant(@PathVariable int plantId,@RequestParam(name="key") String key){
		Plant plant1 = plantservice.viewPlant(plantId,key);
		return new ResponseEntity<>(plant1,HttpStatus.OK);
	}

	@GetMapping("/plants/getbycommonName/{commonName}")
	public ResponseEntity<Plant> viewPlant(@PathVariable String commonName,@RequestParam(name="key") String key){
		Plant plant1 = plantservice.viewPlant(commonName,key);
		return new ResponseEntity<>(plant1,HttpStatus.OK);
	}

	@GetMapping("/plants/getall")
	public ResponseEntity<List<Plant>> viewAllPlants(@RequestParam(name="key") String key) {
		List<Plant> plant1 = plantservice.viewAllPlants(key);
		return new ResponseEntity<>(plant1,HttpStatus.OK);
	}

	@GetMapping("/plants/getallbytype/{typeOfPlant}")
	public ResponseEntity<List<Plant>> viewAllPlants(@PathVariable String typeOfPlant,@RequestParam(name="key") String key){
		List<Plant> plant1 = plantservice.viewAllPlants(typeOfPlant,key);
		return new ResponseEntity<>(plant1,HttpStatus.OK);
	}
    
	@GetMapping("/plants/getallbypage")
	public ResponseEntity<List<Plant>> getPagination( @RequestParam(name="pageNo") Integer pageNo) {
		List<Plant> plant1 = plantservice.getListByPagination(pageNo);
		return new ResponseEntity<>(plant1,HttpStatus.OK);
	}

}
