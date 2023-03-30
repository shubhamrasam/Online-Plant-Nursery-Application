package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.LoginException;
import com.masai.exception.SeedException;
import com.masai.model.Seed;
import com.masai.service.SeedService;

@RestController
@RequestMapping("/seeds")
public class SeedServiceController {

	@Autowired
	private SeedService seedService;

	@PostMapping
	public ResponseEntity<Seed> addSeed(@RequestBody Seed seed, @RequestHeader("key") String key) {
	    try {
	        Seed newSeed = seedService.addSeed(seed, key);
	        return ResponseEntity.status(HttpStatus.CREATED).body(newSeed);
	    } catch (SeedException e) {
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
	    } catch (LoginException e) {
	        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
	    }
	}

	@PutMapping("/{seedId}")
	public ResponseEntity<Seed> updateSeed(@PathVariable("seedId") Integer seedId, @RequestBody Seed seed,
	        @RequestHeader("key") String key) {
	    try {
	        seed.setSeedid(seedId);
	        Seed updatedSeed = seedService.updateSeed(seed, key);
	        return ResponseEntity.ok(updatedSeed);
	    } catch (SeedException e) {
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
	    } catch (LoginException e) {
	        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
	    }
	}

	@DeleteMapping("/{seedId}")
	public ResponseEntity<Seed> deleteSeed(@PathVariable("seedId") Integer seedId, @RequestHeader("key") String key) {
	    try {
	        Seed deletedSeed = seedService.deleteSeed(seedId, key);
	        return ResponseEntity.ok(deletedSeed);
	    } catch (SeedException e) {
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
	    } catch (LoginException e) {
	        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
	    }
	}

	@GetMapping("/{seedId}")
	public ResponseEntity<Seed> viewSeed(@PathVariable("seedId") Integer seedId, @RequestHeader("key") String key) {
	    try {
	        Seed seed = seedService.viewSeed(seedId, key);
	        return ResponseEntity.ok(seed);
	    } catch (SeedException e) {
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
	    } catch (LoginException e) {
	        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
	    }
	}

	@GetMapping(params = "commonName")
	public ResponseEntity<Seed> viewSeedByCommonName(@RequestParam("commonName") String commonName,
	        @RequestHeader("key") String key) {
	    try {
	        Seed seed = seedService.viewSeed(commonName, key);
	        return ResponseEntity.ok(seed);
	    } catch (SeedException e) {
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
	    } catch (LoginException e) {
	        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
	    }
	}

	@GetMapping
	public ResponseEntity<List<Seed>> viewAllSeeds(@RequestHeader("key") String key) {
	    try {
	        List<Seed> seeds = seedService.viewAllSeeds(key);
	        return ResponseEntity.ok(seeds);
	    } catch (SeedException e) {
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
	    } catch (LoginException e) {
	        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
	    }
	}

	@GetMapping(params = "typeOfSeed")
	public ResponseEntity<List<Seed>> viewAllSeedsByType(@RequestParam("typeOfSeed") String typeOfSeed,
	        @RequestHeader("key") String key) {
	    try {
	        List<Seed> seeds = seedService.viewAllSeeds(typeOfSeed, key);
	        return ResponseEntity.ok(seeds);
	    } catch (SeedException e) {
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
	    } catch (LoginException e) {
	    	return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
	    }
	    }
}
