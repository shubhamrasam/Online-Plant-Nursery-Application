package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.LoginException;
import com.masai.exception.SeedException;
import com.masai.model.Plant;
import com.masai.model.Seed;
import com.masai.service.SeedService;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/seeds")
public class SeedServiceController {

	@Autowired
	private SeedService seedService;


	@PostMapping("/add")
	public ResponseEntity<Seed> addSeed(@RequestBody Seed seed,@RequestParam(name="key") String key){
		Seed savedSeed = seedService.addSeed(seed, key);
		return new ResponseEntity<>(savedSeed, HttpStatus.CREATED);
	}

	@PutMapping("/update")
	public ResponseEntity<Seed> updateSeed(@RequestBody Seed seed,@RequestParam(name="key") String key) {
		Seed updatedSeed = seedService.updateSeed(seed, key);
		return new ResponseEntity<>(updatedSeed, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{seedId}")
	public ResponseEntity<Seed> deleteSeed(@PathVariable("seedId") Integer seedId,@RequestParam(name="key") String key) {
		Seed deletedSeed = seedService.deleteSeed(seedId, key);
		return new ResponseEntity<>(deletedSeed, HttpStatus.OK);
	}

	@GetMapping("/get/{seedId}")
	public ResponseEntity<Seed> viewSeed(@PathVariable("seedId") Integer seedId,@RequestParam(name="key") String key){
		Seed seed = seedService.viewSeed(seedId, key);
		return new ResponseEntity<>(seed, HttpStatus.OK);
	}

	@GetMapping("/getByCommon-name/{commonName}")
	public ResponseEntity<Seed> viewSeed(@PathVariable("commonName") String commonName,@RequestParam(name="key") String key) {
		Seed seed = seedService.viewSeed(commonName, key);
		return new ResponseEntity<>(seed, HttpStatus.OK);
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<Seed>> viewAllSeeds(@RequestParam(name="key") String key) {
		List<Seed> seeds = seedService.viewAllSeeds(key);
		return new ResponseEntity<>(seeds, HttpStatus.OK);
	}

	@GetMapping("/getByType-of-seed/{typeOfSeed}")
	public ResponseEntity<List<Seed>> viewAllSeeds(@PathVariable("typeOfSeed") String typeOfSeed,@RequestParam(name="key") String key){
		List<Seed> seeds = seedService.viewAllSeeds(typeOfSeed, key);
		return new ResponseEntity<>(seeds, HttpStatus.OK);
	}
	
	@GetMapping("/getallbypage")
	public ResponseEntity<List<Seed>> getPagination( @RequestParam(name="pageNo") Integer pageNo) {
		List<Seed> seedlist = seedService.getListByPagination(pageNo);
		return new ResponseEntity<>(seedlist,HttpStatus.OK);
	}

}
