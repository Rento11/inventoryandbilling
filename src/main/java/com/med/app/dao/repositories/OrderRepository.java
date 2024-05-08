package com.med.app.dao.repositories;

import com.med.app.dao.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
    public Order findOrderByOrderId(Long orderId);
}
