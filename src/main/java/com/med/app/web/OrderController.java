package com.med.app.web;


import com.med.app.dao.entities.Customer;
import com.med.app.dao.entities.Order;
import com.med.app.dao.entities.Product;
import com.med.app.service.CustomerManager;
import com.med.app.service.OrderManager;
import com.med.app.service.ProductManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller

public class OrderController {

    @Autowired
    private OrderManager orderManager;
    @Autowired
    private ProductManager productManager;
    @Autowired
    private CustomerManager customerManager;


    @GetMapping("/orders")
    public String getOrders(Model model) {
        List<Order> orders = orderManager.getAllOrders();
        model.addAttribute("orders", orders);
        return "orders";
    }

    @GetMapping("/add_order")
    public String addOrder(Model model) {
        model.addAttribute("order", new Order());
        model.addAttribute("customers", customerManager.getAllCustomers());
        model.addAttribute("products", productManager.getAllProducts());
        return "add_order";
    }

    @PostMapping("/add_order")
    public String addOrder2(Model model, @RequestParam(name = "orderDescription") String orderDescription, @RequestParam(name = "product") Long productId, @RequestParam(name = "customer") Long customerId) {
        Product product1 = productManager.getProductById(productId);
        Customer customer1 = customerManager.getCustomerById(customerId);
        Order order = new Order();
        order.setOrderDescription(orderDescription);
        order.setProducts(List.of(product1));
        order.setCustomer(customer1);
        orderManager.addOrder(order);
        if (order != null) {
            model.addAttribute("message","Order added successfully");
        } else{
            model.addAttribute("message","Failed");
        }
        return "redirect:/orders";
    }

}
