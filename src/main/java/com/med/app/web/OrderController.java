package com.med.app.web;


import com.med.app.dao.entities.Order;
import com.med.app.service.CustomerManager;
import com.med.app.service.OrderManager;
import com.med.app.service.ProductManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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

    @PostMapping("/add_orderPost")
    public String saveOrder(@ModelAttribute("order") Order order, Model model) {
        Order savedOrder = orderManager.addOrder(order);
        if (savedOrder != null) {
            model.addAttribute("message","Order added successfully");
        } else{
            model.addAttribute("message","Failed");
        }
        return "redirect:/orders";
    }



}
