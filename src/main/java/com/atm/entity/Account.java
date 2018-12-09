package com.atm.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long accountId;

	private String accountNumber;

	private String accountOwner;

	private double accountBalance;

	private String accountPassword;

	public Account(){}

	public Account(String accountNumber, String accountOwner, double accountBalance, String accountPassword){
		this.accountNumber = accountNumber;
		this.accountOwner = accountOwner;
		this.accountBalance = accountBalance;
		this.accountPassword = accountPassword;
	}

	public Long getAccountId() {
		return accountId;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public String getAccountOwner() {
		return accountOwner;
	}

	public double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}

	public String getAccountPassword() {
		return accountPassword;
	}
}
