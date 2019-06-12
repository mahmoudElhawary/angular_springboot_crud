package com.example.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.app.model.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer>{

}
