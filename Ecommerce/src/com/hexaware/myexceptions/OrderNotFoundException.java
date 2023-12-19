package com.hexaware.myexceptions;

public class OrderNotFoundException extends Exception{
	
	public OrderNotFoundException(){
		System.out.println("Order Not Found Exception");
	}
	
	public String toString() {
		return "Enter valid Order Id";
	}
}
