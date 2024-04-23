package com.med.app.dao.repositories;

import com.med.app.dao.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    public Customer findCustomerByCustomerId(Long customerId);
}
