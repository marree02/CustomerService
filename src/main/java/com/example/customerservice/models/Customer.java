package com.example.customerservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
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

    public String getName() {
        return name;
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
