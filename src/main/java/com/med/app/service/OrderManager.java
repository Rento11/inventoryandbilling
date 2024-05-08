package com.med.app.service;


import com.med.app.dao.entities.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Component

public interface OrderManager {
    public Order addOrder(Order order);
    public Order updateOrder(Order order);
    public boolean deleteOrder(Order order);
    public List<Order> getAllOrders();
    public Order getOrderByOrderId(Long id);
    public boolean deleteOrderById(Long id);
    public double getTotalAmount(Order order);
}
