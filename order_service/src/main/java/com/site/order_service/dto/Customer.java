package com.site.order_service.dto;

// customer information received from the customer service
public record Customer(Long id, String name, String email) {
}