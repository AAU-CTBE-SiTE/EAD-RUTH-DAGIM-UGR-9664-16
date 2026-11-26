package com.site.order_service.dto;

import com.site.order_service.entity.Order;

// an order together with the customer who owns it
public record OrderResponse(Order order, Customer customer) {
}