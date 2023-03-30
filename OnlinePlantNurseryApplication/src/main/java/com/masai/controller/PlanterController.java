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
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.Planter;
import com.masai.service.PlanterService;

@RestController
public class PlanterController {
    
	@Autowired
	PlanterService planterservice;
	
	@PostMapping("/planters/add")
	 public ResponseEntity<Planter> addPlanter(@RequestBody Planter planter) {
		 Planter planter1 = planterservice.addPlanter(planter);
		 return new ResponseEntity<>(planter1,HttpStatus.OK);
	 }
	 
	@PutMapping("/planters/update")
	 public ResponseEntity<Planter> updatePlanter(@RequestBody Planter planter) {
		 Planter planter1 = planterservice.updatePlanter(planter);
		 return new ResponseEntity<>(planter1,HttpStatus.OK);
	 }
	 
	@DeleteMapping("/planter/delete")
	 public ResponseEntity<Planter> deletePlanter(@RequestBody Planter planter) {
		 Planter planter1 = planterservice.deletePlanter(planter);
		 return new ResponseEntity<>(planter1,HttpStatus.OK);
	 }
	 
	 @GetMapping("/planters/getbyId/{planterId}")
	 public ResponseEntity<Planter> viewPlanter(@PathVariable int planterId) {
		 Planter planter1 = planterservice.viewPlanter(planterId);
		 return new ResponseEntity<>(planter1,HttpStatus.OK);
	 }
	 
	 @GetMapping("/planters/getbyshape/{planterShape}")
	 public ResponseEntity<Planter> viewPlanter(@PathVariable String planterShape) {
		 Planter planter1 = planterservice.viewPlanter(planterShape);
		 return new ResponseEntity<>(planter1,HttpStatus.OK);
	 }
	 
	 @GetMapping("/planters/getall")
	 public ResponseEntity<List<Planter>>  viewAllPlanters(){
		 List<Planter> planter1 = planterservice.viewAllPlanters();
		 return new ResponseEntity<>(planter1,HttpStatus.OK);
	 }
	 
	 @GetMapping("/planters/getbycostbetween/{minCost}/{maxCost}")
	 public ResponseEntity<List<Planter>> viewAllPlanters(@PathVariable double minCost ,@PathVariable double maxCost){
		 List<Planter> planter1 = planterservice.viewAllPlanters(minCost, maxCost);
		 return new ResponseEntity<>(planter1,HttpStatus.OK);
	 }
}
