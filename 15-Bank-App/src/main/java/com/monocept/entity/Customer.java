package com.monocept.entity;

import java.util.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;

@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="customer_id")
	private int customerId;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="total_balance")
	private double totalBalance;
	
	@ManyToMany(mappedBy = "customers")
	@JsonIgnore
	Set<Bank> banks = new HashSet<>();
	
	@OneToMany(cascade = CascadeType.REMOVE)
	@JoinColumn(name="fk_customer_id",referencedColumnName = "customer_id")
	@JsonIgnoreProperties(value={"bank","customer"})
	private List<Account> accounts;


	public Customer() {
		super();
	}


	public Customer(int customerId, String firstName, String lastName, double totalBalance, Set<Bank> banks,
			List<Account> accounts) {
		super();
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.totalBalance = totalBalance;
		this.banks = banks;
		this.accounts = accounts;
	}


	public int getCustomerId() {
		return customerId;
	}


	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public double getTotalBalance() {
		return totalBalance;
	}


	public void setTotalBalance(double totalBalance) {
		this.totalBalance = totalBalance;
	}


	public Set<Bank> getBanks() {
		return banks;
	}


	public void setBanks(Set<Bank> banks) {
		this.banks = banks;
	}


	public List<Account> getAccounts() {
		return accounts;
	}


	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

//	public Customer(int customerId, String firstName, String lastName, double totalBalance) {
//	super();
//	this.customerId = customerId;
//	this.firstName = firstName;
//	this.lastName = lastName;
//	this.totalBalance = totalBalance;
//}
	
}
