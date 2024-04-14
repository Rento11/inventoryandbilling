package com.med.app.service;


import com.med.app.dao.entities.Product;
import org.springframework.stereotype.Component;

import java.util.List;

@Component

public interface ProductManager {
    public Product addProduct(Product product);
    public Product updateProduct(Product product);
    public boolean deleteProdcutByName(String productName);
    public Product getProductByName(String productName);
    public List<Product> getAllProducts();
    public boolean deleteProductById(Long productId);
}
