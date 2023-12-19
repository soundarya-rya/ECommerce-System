package com.hexaware.myexceptions;

public class ProductNotFoundException extends Exception {
	public ProductNotFoundException(){
		System.out.println("Product Not Found Exception");
	}
	
	public String toString() {
		return "Product ID not found";
	}
}
