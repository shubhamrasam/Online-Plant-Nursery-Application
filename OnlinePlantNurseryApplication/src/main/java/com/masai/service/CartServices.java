package com.masai.service;

import com.masai.exception.LoginException;
import com.masai.model.Cart;

public interface CartServices {
   
	public String removeFromCart(Integer customerId, String key)throws LoginException;
	
    public Cart addToCart(Cart cart, String key)throws LoginException;
    
    public Cart deleteFromCart(Integer cartId, String key)throws LoginException;
}
