package com.monocept.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;

@Entity
public class Bank {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="bank_id")
	private int bankId;
	
	@Column(name="full_name")
	private String fullName;
	
	private String abbreviation;
	
	@OneToMany(cascade = CascadeType.REMOVE)
	@JoinColumn(name="fk_bank_id", referencedColumnName = "bank_id")
	@JsonIgnoreProperties(value="bank")
	private List<Account> accounts;
	
	@ManyToMany
	@JsonIgnore
	@JoinTable(name="bank_customer",
			joinColumns = @JoinColumn(name="bank_id"),
			inverseJoinColumns = @JoinColumn(name="customer_id")
			)
	Set<Customer> customers= new HashSet<>();

	public Bank() {
	}

	public Bank(int bankId, String fullName, String abbreviation, List<Account> accounts, Set<Customer> customers) {
		super();
		this.bankId = bankId;
		this.fullName = fullName;
		this.abbreviation = abbreviation;
		this.accounts = accounts;
		this.customers = customers;
	}

	public int getBankId() {
		return bankId;
	}

	public void setBankId(int bankId) {
		this.bankId = bankId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getAbbreviation() {
		return abbreviation;
	}

	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	public Set<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(Set<Customer> customers) {
		this.customers = customers;
	}

	
}
