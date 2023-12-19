package com.hexaware.entity;

public class OrderTable {
	private int OrderItemId;
	private int OrderIId;
	private int ProductId;
	private int Quantity;
	
	public int getOrderIId() {
		return OrderIId;
	}
	public int getOrderItemId() {
		return OrderItemId;
	}
	public int getProductId() {
		return ProductId;
	}
	public int getQuantity() {
		return Quantity;
	}

	
	public void setOrderItemId(int OrderItemId) {
		this.OrderItemId = OrderItemId;
	}
	public void setOrderIId(int OrderIId) {
		this.OrderIId = OrderIId;
	}
	public void setProductId(int ProductId) {
		this.ProductId = ProductId;
	}
	public void setQuantity(int Quantity) {
		this.Quantity = Quantity;
	}


	public String toString() {
		return "OrderItem [OrderItemId=" + OrderItemId + ", OrderIId=" + OrderIId +"ProductId"+ProductId+"Quantity"+Quantity+"]";
	}


}
