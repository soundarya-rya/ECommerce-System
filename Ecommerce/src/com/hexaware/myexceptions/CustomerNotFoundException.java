package com.hexaware.myexceptions;

public class CustomerNotFoundException extends Exception {
	public CustomerNotFoundException(){
		System.out.println("Customer Not Found Exception");
	}
	
	public String toString() {
		return "Enter valid Customer credantials";
	}
}
