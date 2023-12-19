package com.hexaware.dao;

import java.util.List;
import java.util.Map;

import com.hexaware.entity.Cart;

public interface CartProcessRepository {
	
	public boolean addToCart(Cart cart);
	
	public boolean removeFromCart(int productId);
	
	public List<Map<Integer, Integer>> getAllFromCart(int customerId);

}
