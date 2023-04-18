package com.monocept.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.monocept.entity.Bank;
import com.monocept.entity.Customer;
import com.monocept.repository.BankRepository;
import com.monocept.repository.CustomerRepository;

@Service
public class CustomerService implements ICustomerService {

	@Autowired
	private CustomerRepository custRepo;
	
	@Autowired
	private BankRepository bankRepo;
	
	@Override
	public List<Customer> saveAll(List<Customer> customers) {
		return custRepo.saveAll(customers);
	}

	@Override
	public List<Customer> findAll() {
		return custRepo.findAll();
	}

	@Override
	public Customer getById(int id) {
		return custRepo.findById(id).get();
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		custRepo.deleteById(id);

	}

	@Override
	public Customer update(int custid, int bankid) {
		
		Customer customer = custRepo.findById(custid).get();
		Bank bank = bankRepo.findById(bankid).get();
		
		Set<Bank> banks = customer.getBanks();
		banks.add(bank);
		customer.setBanks(banks);
		
		
		Set<Customer> customers = bank.getCustomers();
		customers.add(customer);
		bank.setCustomers(customers);
		
		bankRepo.save(bank);
		
		return custRepo.save(customer);
	}

}
