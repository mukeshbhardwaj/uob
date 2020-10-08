package com.user.bankservice.service;

import java.text.ParseException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.user.bankservice.model.TransactionHistoryInput;
import com.user.bankservice.model.TransactionModel;
import com.user.bankservice.model.Transction;
import com.user.bankservice.model.User;
@Service
public interface IUserService {
	public String createUserAccount(User user);
	
	public String fundsTransfer(TransactionModel transactionModel);
	public List<Transction> getStatementByMonth(TransactionHistoryInput transactions)throws ParseException;

//	public String payment(TransactionModel transactionModel, double amount, long bookingid);

}
