package com.hexaware.app;
import com.hexaware.dao.*;
import com.hexaware.entity.Cart;
import com.hexaware.entity.Customer;
import com.hexaware.entity.Product;

import java.util.Scanner;



public class EcomApp{
	
	public static void main(String[] args) {
		System.out.println("***** Welcome to E-Commerce Application *******");
		OrderProcessRepository orderProcessRepository = new OrderManagement();
		CartProcessRepository cartProcessRepository= new CartManagement();
		CustomerRepository customerRepository= new CustomerManagement();
		ProductRepository productRepository= new ProductManagement();
		Scanner scanner = new Scanner(System.in);
		String ch = null;
		do {
			System.out.println("Enter your choice");
			System.out.println("1. Create Customer");
			System.out.println("2. View Customer Details");
			System.out.println("3. Customer Authentication");
			System.out.println("4. Delete Customer");
			System.out.println("5. Create Product");
			System.out.println("6. View All Products");
			System.out.println("7. Delete Product");
			System.out.println("8. Add to Cart");
			System.out.println("9. View Cart items");
			System.out.println("10. Get Orders By Customer ID");
			System.out.println("11. Get Orders By Order ID");
			System.out.println("Enter the choice");
			int choice = scanner.nextInt();
			switch (choice) {
			case 1: {
				Customer customer = new Customer();
				System.out.println("Enter Customer ID");
				int customerId=scanner.nextInt();
				customer.setCustomerid(customerId);
				System.out.println("Enter Customer Name");
				String name=scanner.next();
				customer.setCustomername(name);
				System.out.println("Enter Email Address");
				String email=scanner.next();
				customer.setEmail(email);
				System.out.println("Enter Password");
				String password=scanner.next();
				customer.setPassword(password);
				customerRepository.createCustomer(customer);
				break;
			}
			case 2: {
				System.out.println("Enter Customer ID");
				int customerId=scanner.nextInt();
				customerRepository.retriveCustomer(customerId);
				break;
			}
			case 3: {
				System.out.println("Enter User Name");
				String username=scanner.nextLine();
				System.out.println("Enter Password");
				String password=scanner.nextLine();
				customerRepository.Authentication(username,password);
				break;
			}
			
			case 4: {
				System.out.println("Enter Customer ID");
				int customerId=scanner.nextInt();
				customerRepository.deleteCustomer(customerId);
				break;
			}
			case 5: {
				System.out.println("Enter Product ID");
				int productId=scanner.nextInt();
				System.out.println("Enter Product Name");
				String productName=scanner.nextLine();
				System.out.println("Enter price");
				int price=scanner.nextInt();
				System.out.println("Enter Stock quantity");
				int stockQuantity = scanner.nextInt();
				Product product = new Product(productId , productName, price , stockQuantity );
				
				productRepository.createProduct(product);
				break;
			}
			case 6: {
				productRepository.getAllProduct();
				break;
			}
			case 7: {
				System.out.println("Enter Product ID");
				int productId=scanner.nextInt();
				productRepository.deleteProduct(productId);
				break;
			}
			case 8: {
				System.out.println("Enter Cart ID");
				int cartId=scanner.nextInt();
				System.out.println("Enter Customer ID");
				int customerId=scanner.nextInt();
				System.out.println("Enter Product ID");
				int productId=scanner.nextInt();
				System.out.println("Enter quantity");
				int Quantity = scanner.nextInt();
				Cart cart = new Cart( cartId, customerId, productId, Quantity);
				
				cartProcessRepository.addToCart(cart);
				break;
			}
			case 9: {
				System.out.println("Enter Customer ID");
				int customerId=scanner.nextInt();
				cartProcessRepository.getAllFromCart(customerId);
				break;
			}
			case 10: {
				System.out.println("Enter Customer ID");
				int customerId=scanner.nextInt();
				orderProcessRepository.getOrdersByCustomer(customerId);
				break;
			}
			case 11: {
				System.out.println("Enter Order ID");
				int orderId=scanner.nextInt();
				orderProcessRepository.getOrdersByOrderId(orderId);
				break;
			}
			
			default: {
				System.out.println("Choose a valid choice");
				break;
			}
			}
			System.out.println("Do you want to continue? Y | y ");
			ch = scanner.next();

		} while (ch.equals("Y") || ch.equals("y"));
		scanner.close();
		System.out.println("Thanks for using our system");
	}
}

	
		
