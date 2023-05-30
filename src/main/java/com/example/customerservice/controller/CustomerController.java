package com.example.customerservice.controller;

import com.example.customerservice.models.Customer;
import com.example.customerservice.repositories.CustomerRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Tag(name = "CustomerController", description = "Endpoints for managing customers")
@Validated
public class CustomerController {

    private final CustomerRepository repository;

    public CustomerController(CustomerRepository repository) {
        this.repository = repository;
    }

    @Operation(summary = "Get all customers", description = "Returns a list of all customers")
    @GetMapping("/customers")
    public List<Customer> getCustomers() {
        return this.repository.findAll();
    }

    @Operation(summary = "Get customer by id", description = "Returns a specific customer by their id")
    @GetMapping("/customers/{id}")
    public Customer getCustomerById(@PathVariable Long id) {
        return this.repository.findById(id).orElse(null);
    }

    @Operation(summary = "Create a new customer", description = "Creates a new customer and returns a success message")
    @PostMapping("/customers")
    public String createCustomer(@RequestBody @Valid Customer customer) {
        this.repository.save(customer);
        return "Customer " + customer.getName() + " created";
    }
}
