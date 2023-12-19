package com.hexaware.dao;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.hexaware.entity.Product;
import com.hexaware.myexceptions.ProductNotFoundException;
import com.hexaware.util.DBConnection;

public class ProductManagement implements ProductRepository {
	Connection connection;
	Statement statement;
	PreparedStatement preparedStatement;
	ResultSet resultSet;
	
	public boolean createProduct(Product product) {
			String query = "INSERT INTO products (productId,name, price, StockQuantity) VALUES (?, ?,?,?)";
			try {
				connection= DBConnection.getMyDbConnection();  			
	            preparedStatement = connection.prepareStatement(query);
	            preparedStatement.setInt(1,product.getProductId());
	            preparedStatement.setString(2, product.getProductName());
	            preparedStatement.setInt(3,product.getPrice());
	            preparedStatement.setInt(4, product.getStockQuantity());  
	            preparedStatement.executeUpdate();
	        } catch (SQLException  e) {
	            e.printStackTrace();
	        }
			return false;
	}


	public boolean deleteProduct(int ProductId) {
		String query = "DELETE FROM products WHERE ProductId = ?";
		try {
			connection= DBConnection.getMyDbConnection();  			
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, ProductId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return false;
	}
	
	public List<Product> getAllProduct() {
        List<Product> products = new ArrayList<>();
        String query = "SELECT * FROM Product";
        try {
            
        	connection= DBConnection.getMyDbConnection();  			
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int ProductId = resultSet.getInt("ProductId");
                String productName = resultSet.getString("name");
                int Price = resultSet.getInt("Price");
                int StockQuantity = resultSet.getInt("StockQuantity");
                
               // System.out.println(loanID+" "+customerID+" "+ principalAmount+" "+ interestRate+" "+loanTerm+" "+loanType+" "+loanStatus);
                Product product = new Product(ProductId, productName, Price, StockQuantity);
                System.out.println(product.toString());
                products.add(product);
            }
            if (products.isEmpty()) {
                throw new ProductNotFoundException();
            }
        } catch (SQLException |ProductNotFoundException e) {
            e.printStackTrace();
        }finally {
            closeResources();
        }
        return products;
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
