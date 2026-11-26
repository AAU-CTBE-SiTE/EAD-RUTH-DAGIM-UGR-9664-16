package com.site.order_service.service;

import com.site.order_service.dto.Customer;
import com.site.order_service.dto.OrderResponse;
import com.site.order_service.entity.Order;
import com.site.order_service.repo.OrderRepo;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepo orderRepo;
    private final RestClient customerRestClient;

    // the repo and the RestClient bean are injected here
    public OrderService(OrderRepo orderRepo, RestClient customerRestClient) {
        this.orderRepo = orderRepo;
        this.customerRestClient = customerRestClient;
    }

    // save order
    public Order saveOrder(Order order) {
        if (order.getCustomerId() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "customerId is required");
        }
        getCustomer(order.getCustomerId()); // the customer must exist

        if (orderRepo.findByCustomerId(order.getCustomerId()).isPresent()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Customer already has an order");
        }
        order.setId(null); // always create a new order
        return orderRepo.save(order);
    }

    // get all orders
    public List<Order> getAllOrders() {
        return orderRepo.findAll();
    }

    // which customer owns this order?
    public OrderResponse getOrderById(Long id) {
        Order order = orderRepo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Order not found"));
        return new OrderResponse(order, getCustomer(order.getCustomerId()));
    }

    // what did this customer order?
    public OrderResponse getOrderByCustomerId(Long customerId) {
        Order order = orderRepo.findByCustomerId(customerId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Order not found"));
        return new OrderResponse(order, getCustomer(customerId));
    }

    // calls the customer service on port 8080
    private Customer getCustomer(Long customerId) {
        return customerRestClient.get()
                .uri("/api/customers/{id}", customerId)
                .retrieve()
                .onStatus(status -> status.value() == 404, (request, response) -> {
                    throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer not found");
                })
                .body(Customer.class);
    }
}