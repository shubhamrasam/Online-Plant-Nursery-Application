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


	@PostMapping("/{key}")
	public ResponseEntity<Orders> addOrder(@RequestBody Orders order,@PathVariable String key) throws OrderException, LoginException{
		
		Orders newOrder = ordersService.addOrder(order, key);
		
		return new ResponseEntity<>(newOrder, HttpStatus.CREATED);
	}

	@PutMapping("/{key}")
	public ResponseEntity<Orders> updateOrder(@RequestBody Orders order,@PathVariable String key) throws OrderException, LoginException{
		
		Orders updatedOrder = ordersService.updateOrder(order, key);
		
		return new ResponseEntity<>(updatedOrder, HttpStatus.OK);
	}

	@DeleteMapping("/{orderId}/{key}")
	public ResponseEntity<Orders> deleteOrder(@PathVariable Integer orderId,@PathVariable String key) throws OrderException, LoginException{
		
		Orders deletedOrder = ordersService.deleteOrder(orderId, key);
		
		return new ResponseEntity<>(deletedOrder, HttpStatus.OK);
	}

	@GetMapping("/{orderId}/{key}")
	public ResponseEntity<Orders> viewOrder(@PathVariable Integer orderId,@PathVariable String key) throws OrderException, LoginException{
		
		Orders order = ordersService.viewOrder(orderId, key);
		
		return new ResponseEntity<>(order, HttpStatus.OK);
	}

	@GetMapping("/{key}")
	public ResponseEntity<List<Orders>> viewAllOrders(@PathVariable String key) throws OrderException, LoginException{
		
		List<Orders> orders = ordersService.viewAllOrders(key);
		
		return new ResponseEntity<>(orders, HttpStatus.OK);
	}


}
