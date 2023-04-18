package com.monocept.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.monocept.entity.Transaction;
import com.monocept.service.ITransactionService;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

	@Autowired
	private ITransactionService service;
	
	@GetMapping("/all-transactions")
	public List<Transaction> getAllTransactions(){
		return service.transactions();
	}
	
	@PostMapping("/deposit/{accountNum}/{amount}")
	public Transaction depositAmount(@PathVariable int accountNum,@PathVariable int amount) {
		return service.deposit(accountNum,amount);
	}
}
