package com.monocept.service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.monocept.entity.Account;
import com.monocept.entity.Transaction;
import com.monocept.repository.AccountRepository;
import com.monocept.repository.TransactionRepository;

@Service
public class TransactionServiceImpl implements ITransactionService {

	@Autowired
	private TransactionRepository transRepo;
	
	@Autowired
	private AccountRepository accountRepo;
	
	@Override
	public Transaction save(Transaction trans) {
		
		return transRepo.save(trans);
	}

	@Override
	public List<Transaction> transactions() {
		return transRepo.findAll();
	}

	@Override
	public Transaction deposit(int accountNum, int amount) {
		
		Account account = accountRepo.findById(accountNum).get();
		account.setBalance(account.getBalance()+amount);
		
		UUID uuid=UUID.randomUUID();
		String transactionId = uuid.toString();
		
		Transaction temp = new Transaction(transactionId,accountNum,amount,LocalDate.now(),"Deposit",account);
		
		List<Transaction> transactions = account.getTransactions();
		transactions.add(temp);
		account.setTransactions(transactions);
		
		accountRepo.save(account);
		
		return transRepo.save(temp);
	}

	@Override
	public Transaction withdraw(int accountNum, int amount) {
		
		Account account = accountRepo.findById(accountNum).get();
		if(account.getBalance()>=amount)
		{
			account.setBalance(account.getBalance()-amount);
		
			
			UUID uuid=UUID.randomUUID();
			String transactionId = uuid.toString();
			
			Transaction temp = new Transaction(transactionId,accountNum,amount,LocalDate.now(),"withdraw",account);
			
			List<Transaction> transactions = account.getTransactions();
			transactions.add(temp);
			account.setTransactions(transactions);
			
			accountRepo.save(account);
			
			return transRepo.save(temp);
		}
		
		return null;
	}

	

}
