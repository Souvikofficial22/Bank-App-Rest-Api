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

import com.monocept.entity.Account;
import com.monocept.entity.Bank;
import com.monocept.service.IAccountService;
import com.monocept.service.IBankService;

@RestController
@RequestMapping("/account")
public class AccountController {

	@Autowired
	private IAccountService service;
	
	@PostMapping("/save-all")
	public List<Account> saveAll(@RequestBody List<Account> accounts ){
		return service.saveAll(accounts);
	}
	
	@PostMapping("/save")
	public Account save(@RequestBody Account account) {
		return service.save(account);
	}
	
	@GetMapping("/get")
	public List<Account> findAll(){
		return service.findAll();
	}
	
	@GetMapping("/get/{accountNum}")
	public Account getById(@PathVariable int accountNum) {
		return service.getById(accountNum);
	}
	
	@DeleteMapping("/delete/{accountNum}")
	public void deleteById(@PathVariable int accountNum) {
		service.deleteById(accountNum);
	}
	
	@PutMapping("/update/{accountNum}/bankid/{bankid}/custid/{custid}")
	public Account update(@PathVariable int accountNum,@PathVariable int bankid,@PathVariable int custid) {
		
		return service.update(accountNum,bankid,custid);
	}
	
	@PutMapping("/transfer/{sender_acc_num}/reciever/{reciever_acc_num}/amount/{amount}")
	public Account transfer(@PathVariable int sender_acc_num,@PathVariable int reciever_acc_num,@PathVariable int amount) {
		
		return service.transfer(sender_acc_num,reciever_acc_num,amount);
	}
}
