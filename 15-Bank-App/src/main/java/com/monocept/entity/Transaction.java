package com.monocept.entity;

import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
public class Transaction {

	@Id
	@Column(name="transaction_id")
	private String transactionId;
	
	@Column(name="reciever_acc_num")
	private int recieverAccNum;
	
	
	private double amount;
	
	private LocalDate date;
	
	@Column(name="transaction_type")
	private String transactionType;
	
	@ManyToOne
	@JoinColumn(name="sender_acc_num")
	private Account account;

	public Transaction() {
	}

	

	public Transaction(String transactionId, int recieverAccNum, double amount, LocalDate date, String transactionType,
			Account account) {
		this.transactionId = transactionId;
		this.recieverAccNum = recieverAccNum;
		this.amount = amount;
		this.date = date;
		this.transactionType = transactionType;
		this.account = account;
	}



	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public int getRecieverAccNum() {
		return recieverAccNum;
	}

	public void setRecieverAccNum(int recieverAccNum) {
		this.recieverAccNum = recieverAccNum;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}



	public String getTransactionType() {
		return transactionType;
	}



	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	
	
}
