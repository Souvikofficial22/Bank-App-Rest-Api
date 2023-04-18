package com.monocept.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.monocept.entity.Bank;
import com.monocept.service.IBankService;

@RestController
@RequestMapping("/bank")
public class BankController {

	@Autowired
	private IBankService service;
	
	@PostMapping("/save-all")
	public List<Bank> saveAll(@RequestBody List<Bank> banks ){
		return service.saveAll(banks);
	}
	
	@GetMapping("/get")
	public List<Bank> findAll(){
		return service.findAll();
	}
	
	@GetMapping("/get/{id}")
	public Bank getById(@PathVariable int id) {
		return service.getById(id);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteById(@PathVariable int id) {
		service.deleteById(id);
	}
}
