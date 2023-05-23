package com.example.customerservice.repositories;

import com.example.customerservice.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Customer findBySsn(String ssn);
}
