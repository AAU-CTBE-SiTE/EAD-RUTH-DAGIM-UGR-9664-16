package com.site.customer_service.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class RestClientConfig {

    // this bean lets the customer service talk to the order service
    @Bean
    public RestClient orderRestClient(@Value("${order.service.url}") String orderServiceUrl) {
        return RestClient.builder()
                .baseUrl(orderServiceUrl)
                .build();
    }
}