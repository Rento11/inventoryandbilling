package com.med.app;

import com.med.app.dao.entities.Product;
import com.med.app.service.ProductManager;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AppApplication {

    public static void main(String[] args) {
        SpringApplication.run(AppApplication.class, args);
    }


    @Bean
    public CommandLineRunner commandLineRunner(ProductManager productManager) {
        return args -> {
            Product product = new Product();
            product.setProductName("Clavier mécanique");
            product.setQuantity(100);
            product.setProductUnitPrice(500);
            productManager.addProduct(product);

            Product product2 = new Product();
            product2.setProductName("Écran");
            product2.setQuantity(10);
            product2.setProductUnitPrice(1200);
            productManager.addProduct(product2);
        };
    }

}
