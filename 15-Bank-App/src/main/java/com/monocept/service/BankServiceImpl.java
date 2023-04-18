package com.monocept.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.monocept.entity.Bank;
import com.monocept.repository.BankRepository;

@Service
public class BankServiceImpl implements IBankService {

	@Autowired
	private BankRepository bankRepo;
	
	@Override
	public List<Bank> saveAll(List<Bank> banks) {
		return bankRepo.saveAll(banks);
	}

	@Override
	public List<Bank> findAll() {
		
		return bankRepo.findAll();
		
	}

	@Override
	public Bank getById(int id) {
		return bankRepo.findById(id).get();
	}

	@Override
	public void deleteById(int id) {
		bankRepo.deleteById(id);
		
	}
	
}
