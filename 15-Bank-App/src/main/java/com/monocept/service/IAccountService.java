package com.monocept.service;

import java.util.List;

import com.monocept.entity.Account;

public interface IAccountService {
	public List<Account> saveAll(List<Account> banks);
	public List<Account> findAll();
	public Account getById(int id);
	public void deleteById(int id);
	public Account save(Account account);
	public Account update(int accountNum, int bankid, int custid);
	public Account transfer(int sender_acc_num, int reciever_acc_num, int amount);
}
