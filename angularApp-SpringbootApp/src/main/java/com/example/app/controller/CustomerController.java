package com.example.app.controller;

import java.util.Date;
import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.app.model.Customer;
import com.example.app.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService ;
	
	@GetMapping("/customers")
	public ResponseEntity<List<Customer>> getCustomers() {
		List<Customer> customers=customerService.getAllCustomers();
		return new ResponseEntity<List<Customer>>(customers,HttpStatus.OK) ;
	}
	
	
	@PostMapping("/createCustomer")
	public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer) {
		if(customer== null) {
			throw new NullPointerException("customer can not be null") ;
		}
		customer.setCreateDate(new Date());
		Customer myCustomer =customerService.saveCustomer(customer) ;
		return new ResponseEntity<Customer>(myCustomer,HttpStatus.OK) ;
	}
	
	@GetMapping("/getCustomer/{id}")
	public ResponseEntity<Customer> getCustomer(@PathVariable("id") Integer id) {
		if(id== null) {
			throw new NullPointerException("customer id can not be null") ;
		}
		Customer myCustomer =customerService.findCustomer(id);
		return new ResponseEntity<Customer>(myCustomer,HttpStatus.OK) ;
	}
	
	@PostMapping("/updateCustomer")
	public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer) {
		if(customer== null) {
			throw new NullPointerException("customer can not be null") ;
		}
		customer.setUpdateDate(new Date());
		Customer myCustomer =customerService.updateCustomer(customer) ;
		return new ResponseEntity<Customer>(myCustomer,HttpStatus.OK) ;
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Response> deleteCustomer(@PathVariable("id") Integer id) {
		if(id== null) {
			throw new NullPointerException("customer id can not be null") ;
		}
		customerService.deleteCustomer(id);
		return new ResponseEntity<Response>(new Response(),HttpStatus.OK) ;
	}
}
