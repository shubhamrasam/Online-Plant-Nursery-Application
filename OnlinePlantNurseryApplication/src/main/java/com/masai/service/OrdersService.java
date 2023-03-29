package com.masai.service;

import java.util.List;

import com.masai.exception.OrderException;
import com.masai.model.Orders;

public interface OrdersService {

	public Orders addOrder(Orders order) throws OrderException;
	
	public Orders updateOrder(Orders order) throws OrderException;
	
	public Orders deleteOrder(Integer orderId) throws OrderException;
	
	public Orders viewOrder(Integer orderId) throws OrderException;
	
	public List<Orders> viewAllOrders() throws OrderException;
	
	
}
