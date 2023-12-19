package com.hexaware.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import com.hexaware.entity.*;
import com.hexaware.myexceptions.CustomerNotFoundException;
import com.hexaware.util.DBConnection;

public class CustomerManagement implements CustomerRepository{
	Connection connection;
	Statement statement;
	PreparedStatement preparedStatement;
	ResultSet resultSet;


	public boolean createCustomer(Customer customer) {
		String query = "INSERT INTO customers (customerId, name, email, password) VALUES (?, ?, ?, ?)";
		try {
			connection= DBConnection.getMyDbConnection();  			
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,customer.getCustomerId());
            preparedStatement.setString(2, customer.getCustomerName());
            preparedStatement.setString(3, customer.getEmail());
            preparedStatement.setString(4, customer.getPassword());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return false;
	}

	public boolean retriveCustomer(int CustomerId) {
		String query = "SELECT * from customers WHERE customerId = ?";
		try {
			connection= DBConnection.getMyDbConnection();  			
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, CustomerId);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
            	 int customerId = resultSet.getInt("customerId");
                 String name = resultSet.getString("name");
                 String email = resultSet.getString("email");
                 String pass = resultSet.getString("password");
                 Customer customer = new Customer(customerId, name, email, pass);
                 System.out.println(customer.toString());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return false;
	}

	
	public boolean deleteCustomer(int CustomerId) {
		String query = "DELETE FROM customers WHERE customerId = ?";
		try {
			connection= DBConnection.getMyDbConnection();  			
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, CustomerId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return false;
	}
	public void Authentication(String username, String password) {
		String query = "SELECT * FROM customers WHERE name = ? AND password = ?";
		try {
			connection= DBConnection.getMyDbConnection();
			preparedStatement=connection.prepareStatement(query);
			preparedStatement.setString(1,username);
			preparedStatement.setString(2,password);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {            
                System.out.println("Authentication successfull");
			}
            else {
                throw new CustomerNotFoundException();
            }
		} catch (SQLException | CustomerNotFoundException e) {
		
			e.printStackTrace();
		}finally {
			closeResources();
		}
		
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
