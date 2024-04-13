package com.med.app.web;


import com.med.app.dao.entities.Product;
import com.med.app.service.ProductManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller

public class ProductController {

    @Autowired
    private ProductManager productManager;


    @GetMapping("")
    public String start(){
        return "index";
    }

    @GetMapping("/products")
    public String products(Model model){
        List<Product> products = productManager.getAllProducts();
        model.addAttribute("products", products);
        return "products";
    }

    @GetMapping("add_product")
    public String addProduct(Model model){
        model.addAttribute("product", new Product());
        return "add_product";
    }

}