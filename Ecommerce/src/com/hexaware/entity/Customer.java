package com.hexaware.entity;

public class Customer {
	private int CustomerId;
	private String CustomerName;
	private String email;
	private String Password;
	
	public Customer() {
        this.CustomerId = 0;
        this.CustomerName = "";
        this.email = "";
        this.Password = "";
    }
	
	public Customer(int CustomerId, String CustomerName, String email, String Password) {
        this.CustomerId = CustomerId;
        this.CustomerName = CustomerName;
        this.email = email;
        this.Password=Password;
    }
	
	public int getCustomerId() {
		return CustomerId;
	}

	public String getCustomerName() {
		return CustomerName;
	}
	public String getPassword() {
		return Password;
	}
	 public String getEmail() {
	        return email;
	 }

    public void setEmail(String email) {
        this.email = email;
    }
	
	public void setCustomerid(int CustomerId) {
		this.CustomerId = CustomerId;
	}

	public void setCustomername(String CustomerName) {
		this.CustomerName = CustomerName;
	}
	public void setPassword(String Password) {
		this.Password = Password;
	}
	public String toString() {
		return "Customer [CustomerId=" + CustomerId + ", CustomerName=" + CustomerName +"Email" + email+ "]";
	}

}
