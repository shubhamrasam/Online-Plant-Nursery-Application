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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.LoginException;
import com.masai.exception.OrderException;
import com.masai.model.Orders;
import com.masai.service.OrdersService;

@RestController
@RequestMapping("/orders")
public class OrderServiceController {

	@Autowired
	private OrdersService ordersService;

	@PostMapping("/add")
	public ResponseEntity<?> addOrder(@RequestBody Orders order ,@RequestParam String key){
		
		try {
			
			Orders newOrder = ordersService.addOrder(order,key);
			
			return new ResponseEntity<Orders>(newOrder,HttpStatus.CREATED);
			
		}catch(OrderException e) {
			
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
			
		}catch(LoginException e) {
			
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.UNAUTHORIZED);
			
		}catch(Exception e) {
			
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		
	}

	@PutMapping("/update")
	public ResponseEntity<?> updateOrder(@RequestBody Orders order ,@RequestParam String key){
		
		try {
			
			Orders updatedOrder = ordersService.updateOrder(order,key);
			
			return new ResponseEntity<Orders>(updatedOrder,HttpStatus.OK);
			
		}catch(OrderException e) {
			
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
			
		}catch(LoginException e) {
			
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.UNAUTHORIZED);
			
		}catch(Exception e) {
			
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		
	}

	@DeleteMapping("/delete/{orderId}")
	public ResponseEntity<?> deleteOrder(@PathVariable Integer orderId ,@RequestParam String key){
		
		try {
			
			Orders deletedOrder = ordersService.deleteOrder(orderId,key);
			
			return new ResponseEntity<Orders>(deletedOrder,HttpStatus.OK);
			
		}catch(OrderException e) {
			
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
			
		}catch(LoginException e) {
			
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.UNAUTHORIZED);
			
		}catch(Exception e) {
			
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		
	}

	@GetMapping("/view/{orderId}")
	public ResponseEntity<?> viewOrder(@PathVariable Integer orderId ,@RequestParam String key){
		
		try {
			
			Orders order = ordersService.viewOrder(orderId,key);
			
			return new ResponseEntity<Orders>(order,HttpStatus.OK);
			
		}catch(OrderException e) {
			
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
			
		}catch(LoginException e) {
			
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.UNAUTHORIZED);
			
		}catch(Exception e) {
			
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		
	}

	@GetMapping("/view/all")
	public ResponseEntity<?> viewAllOrders(@RequestParam String key){
		
		try {
			
			List<Orders> orders = ordersService.viewAllOrders(key);
			
			return new ResponseEntity<List<Orders>>(orders,HttpStatus.OK);
			
		}catch(OrderException e) {
			
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
			
		}catch(LoginException e) {
			
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.UNAUTHORIZED);
			
		}catch(Exception e) {
			
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		
	}

}
