package com.uob.uobbank.service.impl;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uob.uobbank.InsufficientBalanceException;
import com.uob.uobbank.model.Account;
import com.uob.uobbank.model.TransactionHistoryInput;
import com.uob.uobbank.model.TransactionModel;
import com.uob.uobbank.model.Transction;
import com.uob.uobbank.model.User;
import com.uob.uobbank.repo.AccountRepo;
import com.uob.uobbank.repo.TransactionRepo;
import com.uob.uobbank.repo.UserRepo;
import com.uob.uobbank.service.IUserService;
import com.uob.uobbank.utils.DateUtills;

@Service
public class UserServiceImpl implements IUserService {
	@Autowired
	UserRepo userRepo;
	@Autowired
	AccountRepo accountRepo;
	@Autowired
	TransactionRepo transactionRepo;

	public String createUserAccount(User user) {
		userRepo.save(user);
		Account account = new Account();
		account.setAccBalance(5000.0);
		Random random = new Random();
		long creatdAccont = (long) (100000000000000L + random.nextFloat() * 900000000000000L);
		account.setAccountNumber(creatdAccont);
		account.setAccType("Saving");
		Long userId = user.getUserId();
		account.setUserId(userId);
		accountRepo.save(account);
		return "account created";
	}

	@Override
	public String fundsTransfer(TransactionModel transactionModel) {
		double requestedAmtFromAccountTransfer = transactionModel.getAmount();
		long fromAccount = transactionModel.getFromAccountNumber();
		long toAccount = transactionModel.getToAccounNumber();

		Account fromAcountdb = accountRepo.findByAccountNumber(fromAccount);
		Account toAcountdb = accountRepo.findByAccountNumber(toAccount);
		double getActualBalance = fromAcountdb.getAccBalance();

		if (requestedAmtFromAccountTransfer > getActualBalance) {
			throw new InsufficientBalanceException("Maintain Sufficient balance for transfer");
		}

		double remainingBalancefromAcc = getActualBalance - requestedAmtFromAccountTransfer;
		fromAcountdb.setAccBalance(remainingBalancefromAcc);
		accountRepo.save(fromAcountdb);

		double updatedRemainingBalancefromAcc = getActualBalance + requestedAmtFromAccountTransfer;
		toAcountdb.setAccBalance(updatedRemainingBalancefromAcc);
		accountRepo.save(toAcountdb);

		Transction transaction = new Transction();
		transaction.setFromAccount(fromAccount);
		transaction.setToAccount(toAccount);
		transaction.setTransactionType(transactionModel.getTransactionType());
		transaction.setDate(LocalDate.now());
		transaction.setTransferredAmount(requestedAmtFromAccountTransfer);
		transactionRepo.save(transaction);

		return "Amount transfred";
	}

	@Override
	public List<Transction> getStatementByMonth(TransactionHistoryInput transactions)throws ParseException {
		String userEnteredMonth = transactions.getMonth();
		int userEnteredYear = transactions.getYear();
		long accountNumber = transactions.getAccountNumber();
		long toAccountNumber = transactions.getAccountNumber();

		int monthNumber = DateUtills.getMonthNumber(userEnteredMonth);
		String startDateMonth = DateUtills.getMonthFirstDay(userEnteredYear, monthNumber);
		String endUserEnteredDate = DateUtills.getMonthLastDaysss(userEnteredYear, monthNumber);
		LocalDate startDate = LocalDate.parse(startDateMonth);
		LocalDate parseDateFormatEndDate = LocalDate.parse(endUserEnteredDate);
		List<Transction> transactionDetails = transactionRepo.findByFromAccountOrToAccount(accountNumber,
				toAccountNumber);

		List<Transction> listOfData = new ArrayList<Transction>();
		for (Transction transaction : transactionDetails) {
			if (transaction.getDate().isAfter(startDate) && transaction.getDate().isBefore(parseDateFormatEndDate)) {
				Transction ts = new Transction();
				BeanUtils.copyProperties(transaction, ts);
				listOfData.add(ts);
			}
		}
		return listOfData;
	}
}
