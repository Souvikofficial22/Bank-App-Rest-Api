package com.monocept.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;

@Entity
public class Account {
	@Id
	@Column(name="account_num")
	private int accountNum;
	
	private double balance;
	
	@ManyToOne
	@JoinColumn(name="fk_bank_id")
	@JsonIgnoreProperties(value={"accounts","bankId"})
	private Bank bank;
	
	@ManyToOne
	@JoinColumn(name="fk_customer_id")
	@JsonIgnoreProperties(value= {"totalBalance","accounts"})
	private Customer customer;

	@OneToMany(cascade = CascadeType.REMOVE)
	@JoinColumn(name="sender_acc_num",referencedColumnName = "account_num")
	@JsonIgnore
	List<Transaction> transactions; 
	
	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

	public Account() {
		super();
	}

	public Account(int accountNum, double balance, Bank bank, Customer customer) {
		this.accountNum = accountNum;
		this.balance = balance;
		this.bank = bank;
		this.customer = customer;
	}

	public int getAccountNum() {
		return accountNum;
	}

	public void setAccountNum(int accountNum) {
		this.accountNum = accountNum;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public Bank getBank() {
		return bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	

	

	

//	public Account(int accountNum, double balance, Bank bank) {
//	super();
//	this.accountNum = accountNum;
//	this.balance = balance;
//	this.bank = bank;
//}
	
}
