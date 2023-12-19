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
import com.hexaware.myexceptions.OrderNotFoundException;
import com.hexaware.util.DBConnection;

public class OrderManagement implements OrderProcessRepository {
	Connection connection;
	Statement statement;
	PreparedStatement preparedStatement;
	ResultSet resultSet;

	
	public List<Map<Integer, Integer>> getOrdersByCustomer(int customerId) {
        List<Map<Integer, Integer>> orders = new ArrayList<>();
        String query = "SELECT * FROM orders INNER JOIN orderitems ON orders.orderid = orderitems.orderid WHERE orders.customerid = ?";
        try {
        	connection= DBConnection.getMyDbConnection();  			
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, customerId);
            resultSet = preparedStatement.executeQuery();
        	while (resultSet.next()) {
                    int productId = resultSet.getInt("productId");
                    int quantity = resultSet.getInt("quantity");
                            Map<Integer, Integer> orderDetails = new HashMap<>();
                            orderDetails.put(productId, quantity);
                            orders.add(orderDetails);
                        }
        	if (orders.isEmpty()) {
                throw new OrderNotFoundException();
            }
        } catch (SQLException | OrderNotFoundException e) {
            e.printStackTrace();
        }finally {
            closeResources();
        }
        return orders;
	}
	public List<Map<Integer, Integer>> getOrdersByOrderId(int orderId) {
        List<Map<Integer, Integer>> orders = new ArrayList<>();
        String query = "SELECT * FROM orders INNER JOIN orderitems ON orders.orderid = orderitems.orderid WHERE orders.orderId = ?";
        try {
        	connection= DBConnection.getMyDbConnection();  			
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, orderId);
            resultSet = preparedStatement.executeQuery();
        	while (resultSet.next()) {
                    int productId = resultSet.getInt("productId");
                    int quantity = resultSet.getInt("quantity");
                    Map<Integer, Integer> orderDetails = new HashMap<>();
                    orderDetails.put(productId, quantity);
                    orders.add(orderDetails);
            }
        	if (orders.isEmpty()) {
                throw new OrderNotFoundException();
            }
        } catch (SQLException | OrderNotFoundException e) {
            e.printStackTrace();
        }
        finally {
            closeResources();
        }
        return orders;
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
	@Override
	public boolean placeOrder() {
		// TODO Auto-generated method stub
		return false;
	}
	
}
