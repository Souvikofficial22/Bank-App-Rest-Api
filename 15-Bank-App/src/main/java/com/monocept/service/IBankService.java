package com.monocept.service;

import java.util.List;
import com.monocept.entity.*;


public interface IBankService {
	
	public List<Bank> saveAll(List<Bank> banks);
	public List<Bank> findAll();
	public Bank getById(int id);
	public void deleteById(int id);
}
