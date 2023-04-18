package com.monocept.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.monocept.entity.Account;
import com.monocept.entity.Bank;
import com.monocept.entity.Customer;
import com.monocept.entity.Transaction;
import com.monocept.repository.AccountRepository;
import com.monocept.repository.BankRepository;
import com.monocept.repository.CustomerRepository;
import com.monocept.repository.TransactionRepository;

@Service
public class AccountServiceImpl implements IAccountService {

	@Autowired
	private AccountRepository accountRepo;
	
	@Autowired
	private BankRepository bankRepo;
	
	@Autowired
	private CustomerRepository custRepo;
	
	@Autowired
	private TransactionRepository transRepo;
	
	@Override
	public List<Account> saveAll(List<Account> accounts) {
		return accountRepo.saveAll(accounts);
	}

	@Override
	public List<Account> findAll() {
		
		return accountRepo.findAll();
		
	}

	@Override
	public Account getById(int id) {
		return accountRepo.findById(id).get();
	}

	@Override
	public void deleteById(int id) {
		accountRepo.deleteById(id);
		
	}

	@Override
	public Account save(Account account) {
		
//		Bank bank = bankRepo.findById(bankid).get();
//		List<Account> accounts = bank.getAccounts();
//		accounts.add(account);
//		bank.setAccounts(accounts);
//		
//		Customer customer = custRepo.findById(custid).get();
//		List<Account> accounts2 = customer.getAccounts();
//		accounts2.add(account);
//		customer.setAccounts(accounts2);
//		
//		bankRepo.save(bank);
//		custRepo.save(customer);
		
		return accountRepo.save(account);
	}

	@Override
	public Account update(int accountNum, int bankid, int custid) {

		Account account = accountRepo.findById(accountNum).get();
		
		Bank bank = bankRepo.findById(bankid).get();
		List<Account> accounts = bank.getAccounts();
		accounts.add(account);
		bank.setAccounts(accounts);
		
		Customer customer = custRepo.findById(custid).get();
		List<Account> accounts2 = customer.getAccounts();
		accounts2.add(account);
		customer.setAccounts(accounts2);
		
		customer.setTotalBalance(customer.getTotalBalance()+account.getBalance());
		
		bankRepo.save(bank);
		custRepo.save(customer);
		
		return accountRepo.save(account);
	}

	@Override
	public Account transfer(int sender_acc_num, int reciever_acc_num, int amount) {
		
		Account sender = accountRepo.findById(sender_acc_num).get();
		Account reciever = accountRepo.findById(reciever_acc_num).get();
		
		if(sender.getBalance()>=amount) {
			sender.setBalance(sender.getBalance()-amount);
			reciever.setBalance(reciever.getBalance()+amount);
			
			UUID uuid=UUID.randomUUID();
			String transactionId = uuid.toString();
			
			Transaction temp = new Transaction(transactionId,reciever_acc_num,amount,LocalDate.now(),"Transfer",sender);
			
			List<Transaction> transactions = sender.getTransactions();
			transactions.add(temp);
			sender.setTransactions(transactions);
			
			List<Transaction> transactions2 = reciever.getTransactions();
			transactions.add(temp);
			reciever.setTransactions(transactions2);
			
			transRepo.save(temp);
			
			accountRepo.save(reciever);
		}
		
		
		
		return accountRepo.save(sender);
	}
	
	
}
