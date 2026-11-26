package com.site.order_service.controller;

import com.site.order_service.dto.OrderResponse;
import com.site.order_service.entity.Order;
import com.site.order_service.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    // save
    @PostMapping
    public Order saveOrder(@RequestBody Order order) {
        return orderService.saveOrder(order);
    }

    // list
    @GetMapping
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    // order by id, with its customer
    @GetMapping("/{id}")
    public OrderResponse getOrderById(@PathVariable("id") Long id) {
        return orderService.getOrderById(id);
    }

    // what did this customer order?
    @GetMapping("/customer/{customerId}")
    public OrderResponse getOrderByCustomerId(@PathVariable("customerId") Long customerId) {
        return orderService.getOrderByCustomerId(customerId);
    }
}