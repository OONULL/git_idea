package com.sq.repository;

import com.sq.pojo.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer,Long> {

    @Override
    public List<Customer> findAll();
}
