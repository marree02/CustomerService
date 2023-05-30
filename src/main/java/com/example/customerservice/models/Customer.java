package com.example.customerservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.Objects;

@Entity
public class Customer {

    @Id
    @GeneratedValue
    private Long id;

    @NotBlank(message = "Name cannot be blank")
    @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
    private String name;

    @NotBlank(message = "SSN cannot be blank")
    @Size(min = 9, max = 11, message = "SSN must be between 9 and 11 characters")
    private String ssn;

    public Customer() {
    }

    public Customer(String name, String ssn) {
        this.name = name;
        this.ssn = ssn;
     //   this.shopOrders = shopOrders;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(id, customer.id) && Objects.equals(name, customer.name) && Objects.equals(ssn, customer.ssn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, ssn);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", ssn='" + ssn + '\'' +
                ", orders=" +  +
                '}';
    }
}
