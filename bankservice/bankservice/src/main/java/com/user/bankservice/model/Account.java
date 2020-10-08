package com.user.bankservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "account")
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
//	@NotNull(message = "ID is required")
	@Column(name = "account_id")
	private Long accountId;
	
	@Column(name = "account_number")
	private Long accountNumber;
	
	@Column(name = "acc_balance")
	private double accBalance;
	
	@Column(name = "acc_type")
	private String accType;
	
	@Column(name = "user_id")
	private Long userId;
	

	public Account() {
	}






	public Account(Long accountId, Long accountNumber, double accBalance, String accType, Long userId) {
		this.accountId = accountId;
		this.accountNumber = accountNumber;
		this.accBalance = accBalance;
		this.accType = accType;
		this.userId = userId;
	}






	public Long getAccountId() {
		return accountId;
	}



	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}



	public Long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public double getAccBalance() {
		return accBalance;
	}

	public void setAccBalance(double accBalance) {
		this.accBalance = accBalance;
	}

	public String getAccType() {
		return accType;
	}

	public void setAccType(String accType) {
		this.accType = accType;
	}



	public Long getUserId() {
		return userId;
	}



	public void setUserId(Long userId) {
		this.userId = userId;
	}



	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", accountNumber=" + accountNumber + ", accBalance=" + accBalance
				+ ", accType=" + accType + ", userId=" + userId + "]";
	}



}
