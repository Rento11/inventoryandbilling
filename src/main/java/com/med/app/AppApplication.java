package com.med.app;

import com.med.app.dao.entities.Customer;
import com.med.app.dao.entities.Product;
import com.med.app.service.CustomerManager;
import com.med.app.service.ProductManager;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AppApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(AppApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

    }
}
