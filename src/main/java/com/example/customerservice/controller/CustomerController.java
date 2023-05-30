package com.example.customerservice.controller;


import com.example.customerservice.models.Customer;
import com.example.customerservice.repositories.CustomerRepository;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "CustomerController", description = "Endpoints for getting all customers")
public class CustomerController {

    private final CustomerRepository repository;

    public CustomerController(CustomerRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/customers")
    public List<Customer> getCustomers() {
        return this.repository.findAll();
    }

    @GetMapping("/customers/{id}")
    public Customer getCustomerById(@PathVariable Long id) {
        return this.repository.findById(id).orElse(null);
    }

    @PostMapping("/customers")
    public String createCustomer(@RequestBody Customer customer) {
        this.repository.save(customer);
        return "Customer " + customer.getName() + " created";
    }
}
