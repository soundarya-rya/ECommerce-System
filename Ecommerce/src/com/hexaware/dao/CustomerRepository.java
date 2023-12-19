package com.hexaware.dao;

import com.hexaware.entity.Customer;

public interface CustomerRepository {
	
	public boolean createCustomer(Customer customer);
	
	public boolean retriveCustomer(int CustomerId);
	
	public boolean deleteCustomer(int CustomerId);
	
	public void Authentication(String username, String password);

}
