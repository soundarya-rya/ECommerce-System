package com.hexaware.entity;

public class Product {
	private int productId;
	private String productName;
	private int price;
	private int StockQuantity;
	
	public Product(int productId, String productName, int price, int StockQuantity) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.StockQuantity=StockQuantity;
    }
	
	public int getProductId() {
		return productId;
	}

	public String getProductName() {
		return productName;
	}
	public int getPrice() {
		return price;
	}
	public int getStockQuantity() {
		return StockQuantity;
	}
	
	public void setProductId(int ProductId) {
		this.productId = ProductId;
	}

	public void setProductName(String ProductName) {
		this.productName = ProductName;
	}
	public void setPrice(int Price) {
		this.price = Price;
	}
	public void setStockQuantity(int StockQuantity) {
		this.StockQuantity = StockQuantity;
	}
	
	public String toString() {
		return "Products [ProductId=" + productId + ", ProductName=" + productName +"Price"+price+"StockQuantity"+StockQuantity+"]";
	}

}
