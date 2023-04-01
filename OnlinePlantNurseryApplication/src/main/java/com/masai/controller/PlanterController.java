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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.Planter;
import com.masai.service.PlanterService;

@RestController
@CrossOrigin(origins="*")
public class PlanterController {
    
	@Autowired
	PlanterService planterservice;
	
	@PostMapping("/planters/add")
	 public ResponseEntity<Planter> addPlanter(@RequestBody Planter planter,@RequestParam(name="plantId",required = false) Integer plantId,@RequestParam(name="seedId",required = false) Integer seedId,@RequestParam(name="key") String key) {
		 Planter planter1 = planterservice.addPlanter(planter,plantId,seedId,key);
		 return new ResponseEntity<>(planter1,HttpStatus.OK);
	 }
	 
	@PutMapping("/planters/update")
	 public ResponseEntity<Planter> updatePlanter(@RequestBody Planter planter,@RequestParam(name="key") String key) {
		 Planter planter1 = planterservice.updatePlanter(planter,key);
		 return new ResponseEntity<>(planter1,HttpStatus.OK);
	 }
	 
	@DeleteMapping("/planter/delete")
	 public ResponseEntity<Planter> deletePlanter(@RequestBody Planter planter,@RequestParam(name="key") String key) {
		 Planter planter1 = planterservice.deletePlanter(planter,key);
		 return new ResponseEntity<>(planter1,HttpStatus.OK);
	 }
	 
	 @GetMapping("/planters/getbyId/{planterId}")
	 public ResponseEntity<Planter> viewPlanter(@PathVariable int planterId,@RequestParam(name="key") String key) {
		 Planter planter1 = planterservice.viewPlanter(planterId,key);
		 return new ResponseEntity<>(planter1,HttpStatus.OK);
	 }
	 
	 @GetMapping("/planters/getbyshape/{planterShape}")
	 public ResponseEntity<Planter> viewPlanter(@PathVariable String planterShape,@RequestParam(name="key") String key) {
		 Planter planter1 = planterservice.viewPlanter(planterShape,key);
		 return new ResponseEntity<>(planter1,HttpStatus.OK);
	 }
	 
	 @GetMapping("/planters/getall")
	 public ResponseEntity<List<Planter>>  viewAllPlanters(@RequestParam(name="key") String key){
		 List<Planter> planter1 = planterservice.viewAllPlanters(key);
		 return new ResponseEntity<>(planter1,HttpStatus.OK);
	 }
	 
	 @GetMapping("/planters/getbycostbetween")
	 public ResponseEntity<List<Planter>> viewAllPlanters(@RequestParam(name = "min") double minCost ,@RequestParam(name = "max") double maxCost, @RequestParam(name="key") String key){
		 List<Planter> planter1 = planterservice.viewAllPlanters(minCost, maxCost,key);
		 return new ResponseEntity<>(planter1,HttpStatus.OK);
	 }
}
