package com.med.app.service;

import com.med.app.dao.entities.Product;
import com.med.app.dao.repositories.ProdcutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service

public class ProductService implements ProductManager {

    @Autowired
    private ProdcutRepository productRepository;


    @Override
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Product product) {
        return productRepository.save(product);
    }


    @Override
    public boolean deleteProdcutByName(String productName) {
        try{
            productRepository.deleteProductByProductName(productName);
            return true;
        }catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public Product getProductByName(String productName) {
        return productRepository.findByProductName(productName);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}
