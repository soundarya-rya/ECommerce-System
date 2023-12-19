package com.hexaware.dao;

import java.util.List;

import com.hexaware.entity.Product;

public interface ProductRepository {

	boolean createProduct(Product product);

	boolean deleteProduct(int ProductId);
	
	public List<Product> getAllProduct();

}
