package com.monocept.service;

import java.util.List;

import com.monocept.entity.Transaction;

public interface ITransactionService {
	public Transaction save(Transaction trans);
	public List<Transaction> transactions();
	public Transaction deposit(int accountNum, int amount);
	public Transaction withdraw(int accountNum, int amount);
}
