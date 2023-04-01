package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.LoginException;
import com.masai.model.Cart;
import com.masai.service.CartServices;


@RestController
@CrossOrigin(origins="*")
public class CartController {

	
	@Autowired
	private CartServices cartService;


	@PostMapping("/add")
	public ResponseEntity<Cart> addCart(@RequestBody Cart cart, @RequestParam(name="key") String key) throws LoginException{
		
		Cart cartObject = cartService.addToCart(cart, key);
		
		return new ResponseEntity<>(cartObject, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/delete/{cartId}")
	public ResponseEntity<Cart> deleteOrder(@PathVariable Integer cartId,@RequestParam(name="key") String key) throws LoginException{
		
		Cart cartObject = cartService.deleteFromCart(cartId, key);
		
		return new ResponseEntity<>(cartObject, HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteByCustomerId/{customerId}")
	public ResponseEntity<String> deleteOrderbyCustomerId(@PathVariable Integer customerId,@RequestParam(name="key") String key) throws LoginException{
		
		String output = cartService.removeFromCart(customerId, key);
		
		return new ResponseEntity<>(output, HttpStatus.OK);
	}
	
	
}
