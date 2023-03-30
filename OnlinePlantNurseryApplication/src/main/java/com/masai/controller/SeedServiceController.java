package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.SeedException;
import com.masai.model.Seed;
import com.masai.service.SeedService;

@RestController
@RequestMapping("/seeds")
public class SeedServiceController {

	@Autowired
	private SeedService seedService;

	@PostMapping("/")
	public ResponseEntity<Seed> addSeed(@RequestBody Seed seed) throws SeedException {
	    Seed addedSeed = seedService.addSeed(seed);
	    return ResponseEntity.ok(addedSeed);
	}

	@PutMapping("/")
	public ResponseEntity<Seed> updateSeed(@RequestBody Seed seed) throws SeedException {
	    Seed updatedSeed = seedService.updateSeed(seed);
	    return ResponseEntity.ok(updatedSeed);
	}

	@DeleteMapping("/{seedId}")
	public ResponseEntity<Seed> deleteSeed(@PathVariable Integer seedId) throws SeedException {
	    Seed deletedSeed = seedService.deleteSeed(seedId);
	    return ResponseEntity.ok(deletedSeed);
	}

	@GetMapping("/{seedId}")
	public ResponseEntity<Seed> viewSeed(@PathVariable Integer seedId) throws SeedException {
	    Seed seed = seedService.viewSeed(seedId);
	    return ResponseEntity.ok(seed);
	}

	@GetMapping("/name/{commonName}")
	public ResponseEntity<Seed> viewSeedByName(@PathVariable String commonName) throws SeedException {
	    Seed seed = seedService.viewSeed(commonName);
	    return ResponseEntity.ok(seed);
	}

	@GetMapping("/")
	public ResponseEntity<List<Seed>> viewAllSeeds() throws SeedException {
	    List<Seed> seeds = seedService.viewAllSeeds();
	    return ResponseEntity.ok(seeds);
	}

	@GetMapping("/type/{typeOfSeed}")
	public ResponseEntity<List<Seed>> viewAllSeedsByType(@PathVariable String typeOfSeed) throws SeedException {
	    List<Seed> seeds = seedService.viewAllSeeds(typeOfSeed);
	    return ResponseEntity.ok(seeds);
	}
}
