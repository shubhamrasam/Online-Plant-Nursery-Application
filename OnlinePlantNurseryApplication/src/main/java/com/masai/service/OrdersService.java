package com.masai.service;

import java.util.List;

import com.masai.exception.LoginException;
import com.masai.exception.OrderException;
import com.masai.model.Orders;

public interface OrdersService {

	public Orders addOrder(Orders order,String key) throws OrderException,LoginException;
	
	public Orders updateOrder(Orders order,String key) throws OrderException,LoginException;
	
	public Orders deleteOrder(Integer orderId,String key) throws OrderException,LoginException;
	
	public Orders viewOrder(Integer orderId,String key) throws OrderException,LoginException;
	
	public List<Orders> viewAllOrders(String key) throws OrderException,LoginException;
	
	
}
