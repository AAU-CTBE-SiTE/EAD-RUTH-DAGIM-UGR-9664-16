package com.site.customer_service.service;

import com.site.customer_service.entity.Customer;
import com.site.customer_service.repo.CustomerRepo;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepo customerRepo;

    public CustomerService(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    // save customer
    public Customer saveCustomer(Customer customer) {
        if (customer.getId() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Customer id is required");
        }
        return customerRepo.save(customer);
    }

    // get all customers
    public List<Customer> getAllCustomers() {
        return customerRepo.findAll();
    }

    // get customer by id
    public Customer getCustomerById(Long id) {
        return customerRepo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer not found"));
    }

    // delete customer by id
    public void deleteCustomerById(Long id) {
        customerRepo.deleteById(id);
    }
}