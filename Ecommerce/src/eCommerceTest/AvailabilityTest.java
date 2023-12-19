package eCommerceTest;

import org.junit.jupiter.api.Test;

import com.hexaware.dao.ProductManagement;
import com.hexaware.entity.Product;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class AvailabilityTest {
	
    @Test
    public void testProductCreation() {
        ProductManagement productManagement = new ProductManagement();
        Product newProduct = new Product(14, "HDMI cable", 200 , 20);
        productManagement.createProduct(newProduct);

        List<Product> availableProducts = productManagement.getAllProduct();

        boolean productExists = availableProducts.stream()
                                    .anyMatch(product -> product.getProductId() == newProduct.getProductId());

        assertTrue(productExists, "Product should be created and exist in the available products list");
    }
}

