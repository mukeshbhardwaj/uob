package com.uob.uobbank.service;

import java.text.ParseException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.uob.uobbank.model.TransactionHistoryInput;
import com.uob.uobbank.model.TransactionModel;
import com.uob.uobbank.model.Transction;
import com.uob.uobbank.model.User;
@Service
public interface IUserService {
	public String createUserAccount(User user);
	
	public String fundsTransfer(TransactionModel transactionModel);
	public List<Transction> getStatementByMonth(TransactionHistoryInput transactions)throws ParseException;

}
