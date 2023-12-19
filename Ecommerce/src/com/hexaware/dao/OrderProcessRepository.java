package com.hexaware.dao;

import java.util.List;
import java.util.Map;

public interface OrderProcessRepository {
	
	boolean placeOrder();
	
	public List<Map<Integer, Integer>> getOrdersByCustomer(int CustomerId);
	
	public List<Map<Integer, Integer>> getOrdersByOrderId(int orderId);
	

}
