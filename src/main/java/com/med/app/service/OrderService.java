package com.med.app.service;

import com.med.app.dao.entities.Order;
import com.med.app.dao.entities.Product;
import com.med.app.dao.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



@Service

public class OrderService implements OrderManager{

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Order addOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order updateOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public boolean deleteOrder(Order order) {
        try{
            orderRepository.delete(order);
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order getOrderByOrderId(Long id) {
        return orderRepository.findOrderByOrderId(id);
    }

    @Override
    public boolean deleteOrderById(Long id) {
        try{
            orderRepository.deleteById(id);
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public double getTotalAmount(Order order) {
        double totalAmount = 0;
        List<Product> products = order.getProducts();
        for (Product product : products) {
            totalAmount = product.getProductUnitPrice() * product.getQuantity();
        }
        return totalAmount;
    }
}
