package com.monocept.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.monocept.entity.Customer;
import com.monocept.service.ICustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private ICustomerService service;
	
	@PostMapping("/save-all")
	public List<Customer> saveAll(@RequestBody List<Customer> customers ){
		return service.saveAll(customers);
	}
	
	@GetMapping("/get")
	public List<Customer> findAll(){
		return service.findAll();
	}
	
	@GetMapping("/get/{id}")
	public Customer getById(@PathVariable int id) {
		return service.getById(id);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteById(@PathVariable int id) {
		service.deleteById(id);
	}
	
	@PutMapping("/custid/{custid}/bankid/{bankid}")
	public Customer addProjectsToEmployee(@PathVariable int custid,@PathVariable int bankid) {
		
		return service.update(custid,bankid);
	}
}
