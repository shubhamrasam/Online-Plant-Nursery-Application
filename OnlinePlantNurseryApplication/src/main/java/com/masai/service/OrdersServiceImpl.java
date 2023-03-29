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
		
		Orders orderObject = ordersRepository.save(order);
		
		if(orderObject == null) {
			
			throw new OrderException("Order is not added");
			
		}
		
		return orderObject;
		
	}

	@Override
	public Orders updateOrder(Orders order) throws OrderException {
		
		Optional<Orders> orderOpt =  ordersRepository.findById(order.getBookingOrderId());
		
		if(orderOpt.isEmpty()) {
			
			throw new OrderException("");
			
		}
		
		return null;
	}

	@Override
	public Orders deleteOrder(Integer orderId) throws OrderException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Orders viewOrder(Integer orderId) throws OrderException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Orders> viewAllOrders() throws OrderException {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
