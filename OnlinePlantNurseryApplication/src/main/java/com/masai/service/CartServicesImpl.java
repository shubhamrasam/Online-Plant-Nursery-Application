package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.LoginException;
import com.masai.model.AdminSession;
import com.masai.model.Cart;
import com.masai.model.CustomerSession;
import com.masai.repository.AdminSessionRepository;
import com.masai.repository.CartRepository;
import com.masai.repository.CustomerSessionRepository;

@Service
public class CartServicesImpl implements CartServices{
	
	@Autowired
	private AdminSessionRepository adminSessionRepository;
	
	@Autowired
	private CustomerSessionRepository customerSessionRepository;
	
	@Autowired
	private CartRepository cartRepository;

	@Override
	public String removeFromCart(Integer customerId, String key) throws LoginException {
		
		AdminSession adminSession = adminSessionRepository.findByUuid(key);
		CustomerSession customerSession = customerSessionRepository.findByUuid(key);
        if(adminSession == null && customerSession==null) throw new LoginException("Key is not valid login again.");
        
         cartRepository.deleteFromcustomerId(customerId);
        
//        if(cartList.isEmpty())return "no Item Found";
         return "Cart Deleted Successfully";
	}

	@Override
	public Cart addToCart(Cart cart, String key) throws LoginException {
		
		AdminSession adminSession = adminSessionRepository.findByUuid(key);
		CustomerSession customerSession = customerSessionRepository.findByUuid(key);
        if(adminSession == null && customerSession==null) throw new LoginException("Key is not valid login again.");
        
        Cart cartObject = cartRepository.save(cart);
        
        if(cartObject==null) {
        	
        	throw new LoginException("Cart Not added Successfully");
        }
        
        
		return cartObject;
	}

	@Override
	public Cart deleteFromCart(Integer cartId, String key) throws LoginException {
		AdminSession adminSession = adminSessionRepository.findByUuid(key);
		CustomerSession customerSession = customerSessionRepository.findByUuid(key);
        if(adminSession == null && customerSession==null) throw new LoginException("Key is not valid login again.");
        
        Optional<Cart> cartOpt = cartRepository.findById(cartId);
        
        if(cartOpt.isEmpty()) {
        	
        	throw new LoginException("Cart is not found by id: "+ cartId);
        }
        
        cartRepository.delete(cartOpt.get());
        
		return cartOpt.get();
	}

}
