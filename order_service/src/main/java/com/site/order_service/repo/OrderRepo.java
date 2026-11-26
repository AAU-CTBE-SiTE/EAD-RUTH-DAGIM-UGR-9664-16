package com.site.order_service.repo;

import com.site.order_service.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrderRepo extends JpaRepository<Order, Long> {

    // find the one order belonging to a customer
    Optional<Order> findByCustomerId(Long customerId);
}