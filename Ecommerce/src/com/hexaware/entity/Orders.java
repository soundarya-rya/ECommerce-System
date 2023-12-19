package com.hexaware.entity;

public class Orders {
	private int OrderId;
	private int CustomerId;
	private String OrderDate;
	private int TotalPrice;
	
	public int getOrderId() {
		return OrderId;
	}

	public String getOrderDate() {
		return OrderDate;
	}
	public int getCustomerId() {
		return CustomerId;
	}
	public int getTotalPrice() {
		return TotalPrice;
	}
	
	public void setOrderId(int OrderId) {
		this.OrderId = OrderId;
	}

	public void setOrderDate(String OrderDate) {
		this.OrderDate = OrderDate;
	}
	public void setPrice(int CustomerId) {
		this.CustomerId = CustomerId;
	}
	public void setTotalPrice(int TotalPrice) {
		this.TotalPrice = TotalPrice;
	}
	
	public String toString() {
		return "Orders [OrderId=" + OrderId + ", CustomerId=" + CustomerId +"OrderDate"+OrderDate+"TotalPrice"+TotalPrice+"]";
	}

}
