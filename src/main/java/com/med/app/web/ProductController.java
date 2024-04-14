package com.med.app.web;


import com.med.app.dao.entities.Product;
import com.med.app.service.ProductManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @GetMapping("/add_product")
    public String addProduct(Model model){
        model.addAttribute("product", new Product());
        return "add_product";
    }

    @PostMapping("/add_productPost")
    public String add_product(Model model, @RequestParam(name= "productName") String productName, @RequestParam(name = "quantity") int quantity, @RequestParam(name = "unitPrice") double unitPrice){
        Product product = new Product();
        product.setProductName(productName);
        product.setQuantity(quantity);
        product.setProductUnitPrice(unitPrice);
        productManager.addProduct(product);
        return "redirect:products";
    }
    @GetMapping("/delete_product")
    public String deleteProduct(Model model, @RequestParam(name = "id") Long id){
        if(productManager.deleteProductById(id)){
            return "redirect:products";
        }
        else{
            return "redirect:error";
        }
    }
}
