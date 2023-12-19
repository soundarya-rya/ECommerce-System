package com.hexaware.entity;

public class Cart {
	private int CartId;
	private int CustomerId;
	private int ProductId;
	private int Quantity;
	
	public Cart(int CartId, int CustomerId, int ProductId, int Quantity) {
        this.CartId = CartId;
        this.CustomerId = CustomerId;
        this.ProductId = ProductId;
        this.Quantity=Quantity;
    }
	
	public int getCartId() {
		return CartId;
	}
	public int getCustomerId() {
		return CustomerId;
	}
	public int getProductId() {
		return ProductId;
	}
	public int getQuantity() {
		return Quantity;
	}

	
	public void setCartId(int CartId) {
		this.CartId = CartId;
	}
	public void setCustid(int CustomerId) {
		this.CustomerId = CustomerId;
	}
	public void setProductId(int ProductId) {
		this.ProductId = ProductId;
	}
	public void setQuantity(int Quantity) {
		this.Quantity = Quantity;
	}


	public String toString() {
		return "Cart [CartId=" + CartId + ", CustomerId=" + CustomerId +"ProductId"+ProductId+"Quantity"+Quantity+"]";
	}

}
