package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.CustomerException;
import com.masai.exception.LoginException;
import com.masai.exception.OrderException;
import com.masai.exception.PlanterException;
import com.masai.model.Customer;
import com.masai.model.CustomerSession;
import com.masai.model.Orders;
import com.masai.model.Planter;
import com.masai.repository.AdminSessionRepository;
import com.masai.repository.CustomerRepository;
import com.masai.repository.CustomerSessionRepository;
import com.masai.repository.OrdersRepository;
import com.masai.repository.PlanterRepository;

@Service
public class OrdersServiceImpl implements OrdersService{

	@Autowired
	private OrdersRepository ordersRepository;
	
	@Autowired
	private AdminSessionRepository adminSessionRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private PlanterRepository planterRepository;
	
	@Autowired
	private CustomerSessionRepository customerSessionRepository;
	
	@Override
	public Orders addOrder(Orders order ,Integer planterId, Integer customerId, String key) throws OrderException , LoginException,CustomerException ,PlanterException{
		
        CustomerSession customerSession = customerSessionRepository.findByUuid(key); 
        if(customerSession == null) throw new LoginException("Key is not valid login again.");

			
			if(customerId!=null) {
				Optional<Customer> c1 = customerRepository.findById(customerId);
				if(c1.isEmpty()) throw new CustomerException("No customer found with id: " + customerId);
				else order.setCustomer(c1.get());
			}
			
			if(planterId!=null) {
				Optional<Planter> p1 = planterRepository.findById(planterId);
				if(p1.isEmpty()) throw new PlanterException("No Planter Found with given Id: "+planterId);
				else order.setPlanters(p1.get());
			}
			
			
			return ordersRepository.save(order);
	
		
	}

	@Override
	public Orders updateOrder(Orders order ,String key) throws OrderException, LoginException {
		
        CustomerSession customerSession = customerSessionRepository.findByUuid(key);
        
        if(customerSession == null) throw new LoginException("Key is not valid login again.");
		
		Optional<Orders> orderOpt =  ordersRepository.findById(order.getBookingOrderId());
		
		if(orderOpt.isEmpty()) {
			
			throw new OrderException("Order is not present with id: "+order.getBookingOrderId());
			
		}
		
		return ordersRepository.save(order);
	}

	@Override
	public Orders deleteOrder(Integer orderId ,String key) throws OrderException , LoginException{
		
        CustomerSession customerSession = customerSessionRepository.findByUuid(key);
        
        if(customerSession == null) throw new LoginException("Key is not valid login again.");
		
		Optional<Orders> orderOpt =  ordersRepository.findById(orderId);
		
		if(orderOpt.isEmpty()) {
			
			throw new OrderException("Order is not present with id: "+orderId);
			
		}
		
		ordersRepository.delete(orderOpt.get());
		
		return orderOpt.get();
	}

	@Override
	public Orders viewOrder(Integer orderId ,String key) throws OrderException, LoginException {
		
        CustomerSession customerSession = customerSessionRepository.findByUuid(key);
        
        if(customerSession == null) throw new LoginException("Key is not valid login again.");
		
		Optional<Orders> orderOpt =  ordersRepository.findById(orderId);
		
		if(orderOpt.isEmpty()) {
			
			throw new OrderException("Order is not present with id: "+orderId);
			
		}
		
		return orderOpt.get();
		
	}

	@Override
	public List<Orders> viewAllOrders(String key) throws OrderException, LoginException {
		
        CustomerSession customerSession = customerSessionRepository.findByUuid(key);
        
        if(customerSession == null) throw new LoginException("Key is not valid login again.");
		
		List<Orders> orders = ordersRepository.findAll();
		
		if(orders.isEmpty()) {
			
			throw new OrderException("Orders are not present");
			
		}
		
		return orders;
	}

	
	
}
