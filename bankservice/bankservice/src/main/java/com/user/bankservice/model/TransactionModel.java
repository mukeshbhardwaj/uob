package com.user.bankservice.model;

public class TransactionModel {
	private long fromAccountNumber;
	private long toAccounNumber;
	private double amount;
	private String transactionType;
	public long getFromAccountNumber() {
		return fromAccountNumber;
	}
	public void setFromAccountNumber(long fromAccountNumber) {
		this.fromAccountNumber = fromAccountNumber;
	}
	public long getToAccounNumber() {
		return toAccounNumber;
	}
	public void setToAccounNumber(long toAccounNumber) {
		this.toAccounNumber = toAccounNumber;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	
	
}
