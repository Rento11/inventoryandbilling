package com.med.app.dao.repositories;

import com.med.app.dao.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdcutRepository extends JpaRepository<Product, Long> {
    public void deleteProductByProductName(String productName);
    public Product findByProductName(String productName);
}
