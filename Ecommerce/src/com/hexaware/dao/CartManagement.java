package com.hexaware.dao;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hexaware.entity.Cart;
import com.hexaware.util.DBConnection;

public class CartManagement implements CartProcessRepository {
	Connection connection;
	Statement statement;
	PreparedStatement preparedStatement;
	ResultSet resultSet;

	public boolean addToCart(Cart cart) {
		String query = "INSERT INTO cart (CartId, CustomerId, ProductId, Quantity) VALUES (?, ?,?,?)";
		try {
			connection= DBConnection.getMyDbConnection();  			
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,cart.getCartId());
            preparedStatement.setInt(2, cart.getCustomerId());
            preparedStatement.setInt(3,cart.getProductId());
            preparedStatement.setInt(4, cart.getQuantity());  
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return false;
	}

	public boolean removeFromCart(int productId) {
		String query = "DELETE FROM cart WHERE ProductId = ?";
		try {
			connection= DBConnection.getMyDbConnection();  			
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, productId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return false;
		
	}
	
	public List<Map<Integer, Integer>> getAllFromCart(int customerId){
		 List<Map<Integer, Integer>> carts = new ArrayList<>();
	        String query = "SELECT * FROM cart WHERE customerid = ?";
	        try {
	        	connection= DBConnection.getMyDbConnection();  			
	            preparedStatement = connection.prepareStatement(query);
	            preparedStatement.setInt(1, customerId);
	            resultSet = preparedStatement.executeQuery();
	        	while (resultSet.next()) {
	                    int productId = resultSet.getInt("productId");
	                    int quantity = resultSet.getInt("quantity");
	                            Map<Integer, Integer> cartDetails = new HashMap<>();
	                            cartDetails.put(productId, quantity);
	                            carts.add(cartDetails);
	                        }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }finally {
	            closeResources();
	        }
	        return carts;
		
	}
	
	private void closeResources() {
        try {
            if (resultSet != null) resultSet.close();
            if (statement != null) statement.close();
            if (preparedStatement != null) preparedStatement.close();
            if (connection != null) connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
}
