package com.med.app;

import com.med.app.dao.entities.Customer;
import com.med.app.dao.entities.Product;
import com.med.app.service.CustomerManager;
import com.med.app.service.ProductManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AppApplication implements CommandLineRunner {



    @Autowired
    private CustomerManager customerManager;
    @Autowired
    private ProductManager productManager;


    public static void main(String[] args) {
        SpringApplication.run(AppApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // This method is empty because we don't need to perform any additional actions on application startup.
    }

    @Bean
    public Customer customer1() {
        Customer customer = new Customer();
        customer.setName("John Doe");
        customer.setEmail("john@example.com");
        customer.setAddress("123 Main St");
        return customerManager.addCustomer(customer);
    }

    @Bean
    public Customer customer2() {
        Customer customer = new Customer();
        customer.setName("Jane Smith");
        customer.setEmail("jane@example.com");
        customer.setAddress("456 Elm St");
        return customerManager.addCustomer(customer);
    }

    @Bean
    public Product product1() {
        Product product = new Product();
        product.setProductName("Product 1");
        product.setQuantity(10);
        product.setProductUnitPrice(25.99);
        return productManager.addProduct(product);
    }

    @Bean
    public Product product2() {
        Product product = new Product();
        product.setProductName("Product 2");
        product.setQuantity(20);
        product.setProductUnitPrice(39.99);
        return productManager.addProduct(product);
    }
}
