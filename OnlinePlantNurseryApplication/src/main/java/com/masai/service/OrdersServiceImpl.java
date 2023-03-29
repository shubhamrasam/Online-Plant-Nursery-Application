package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.OrderException;
import com.masai.model.Orders;
import com.masai.repository.OrdersRepository;

@Service
public class OrdersServiceImpl implements OrdersService{

	@Autowired
	private OrdersRepository ordersRepository;
	
	@Override
	public Orders addOrder(Orders order) throws OrderException {
		
		Optional<Orders> optOrder = ordersRepository.findById(order.getBookingOrderId());
		
		if(optOrder.isEmpty()) {
			
			return ordersRepository.save(order);
		}
		
		throw new OrderException("Order already present with id: "+order.getBookingOrderId());
		
	}

	@Override
	public Orders updateOrder(Orders order) throws OrderException {
		
		Optional<Orders> orderOpt =  ordersRepository.findById(order.getBookingOrderId());
		
		if(orderOpt.isEmpty()) {
			
			throw new OrderException("Order is not present with id: "+order.getBookingOrderId());
			
		}
		
		return ordersRepository.save(order);
	}

	@Override
	public Orders deleteOrder(Integer orderId) throws OrderException {
		
		Optional<Orders> orderOpt =  ordersRepository.findById(orderId);
		
		if(orderOpt.isEmpty()) {
			
			throw new OrderException("Order is not present with id: "+orderId);
			
		}
		
		ordersRepository.delete(orderOpt.get());
		
		return orderOpt.get();
	}

	@Override
	public Orders viewOrder(Integer orderId) throws OrderException {
		
		Optional<Orders> orderOpt =  ordersRepository.findById(orderId);
		
		if(orderOpt.isEmpty()) {
			
			throw new OrderException("Order is not present with id: "+orderId);
			
		}
		
		return orderOpt.get();
		
	}

	@Override
	public List<Orders> viewAllOrders() throws OrderException {
		
		List<Orders> orders = ordersRepository.findAll();
		
		if(orders.isEmpty()) {
			
			throw new OrderException("No Order is present");
			
		}
		
		return orders;
	}

	
	
}
