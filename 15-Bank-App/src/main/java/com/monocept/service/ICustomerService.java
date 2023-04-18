package com.monocept.service;

import java.util.List;

import com.monocept.entity.Bank;
import com.monocept.entity.Customer;

public interface ICustomerService {
	public List<Customer> saveAll(List<Customer> customers);
	public List<Customer> findAll();
	public Customer getById(int id);
	public void deleteById(int id);
	public Customer update(int custid, int bankid);
}
