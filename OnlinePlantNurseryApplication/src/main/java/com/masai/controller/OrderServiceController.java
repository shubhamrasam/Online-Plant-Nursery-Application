package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.CustomerException;
import com.masai.exception.LoginException;
import com.masai.exception.OrderException;
import com.masai.model.Orders;
import com.masai.service.OrdersService;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/orders")
@PreAuthorize("hasRole('ADMIN')")
public class OrderServiceController {

	@Autowired
	private OrdersService ordersService;

	@PreAuthorize("hasRole('NORMAL')")
	@PostMapping("/add")
	public ResponseEntity<Orders> addOrder(@RequestBody Orders order,@RequestParam(name="planterId") Integer planterId,@RequestParam(name="customerId") Integer customerId, @RequestParam(name="key") String key) throws OrderException, LoginException{
		
		Orders newOrder = ordersService.addOrder(order, planterId, customerId, key);
		
		return new ResponseEntity<>(newOrder, HttpStatus.CREATED);
	}
	@PreAuthorize("hasRole('NORMAL')")
	@PatchMapping("/update")
	public ResponseEntity<Orders> updateOrder(@RequestBody Orders order,@RequestParam(name="key") String key) throws OrderException, LoginException{
		
		
		Orders updatedOrder = ordersService.updateOrder(order, key);
		
		return new ResponseEntity<>(updatedOrder, HttpStatus.OK);
	}
    
	@DeleteMapping("/delete/{orderId}")
	public ResponseEntity<Orders> deleteOrder(@PathVariable Integer orderId,@RequestParam(name="cid") Integer customerId,@RequestParam(name="key") String key) throws OrderException, LoginException,CustomerException{
		
		Orders deletedOrder = ordersService.deleteOrder(orderId, key ,customerId);
		
		return new ResponseEntity<>(deletedOrder, HttpStatus.OK);
	}

	@GetMapping("/getById/{orderId}")
	public ResponseEntity<Orders> viewOrder(@PathVariable Integer orderId,@RequestParam(name="key") String key) throws OrderException, LoginException{
		
		Orders order = ordersService.viewOrder(orderId, key);
		
		return new ResponseEntity<>(order, HttpStatus.OK);
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<Orders>> viewAllOrders(@RequestParam(name="key") String key) throws OrderException, LoginException{
		
		List<Orders> orders = ordersService.viewAllOrders(key);
		
		return new ResponseEntity<>(orders, HttpStatus.OK);
	}


}
