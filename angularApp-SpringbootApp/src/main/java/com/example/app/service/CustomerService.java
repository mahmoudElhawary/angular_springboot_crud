package com.example.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.model.Customer;
import com.example.app.repository.CustomerRepository;

@Service
@Transactional
public class CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository ;
	public List<Customer> getAllCustomers() {
		return (List<Customer>) customerRepository.findAll();
	}
	public Customer saveCustomer(Customer customer) {
		return customerRepository.save(customer);
	}
	public Customer findCustomer(Integer id) {
		return customerRepository.findById(id).get();
	}
	public Customer updateCustomer(Customer customer) {
		return customerRepository.save(customer);
	}
	public void deleteCustomer(Integer id) {
		customerRepository.deleteById(id);
	}	

}
