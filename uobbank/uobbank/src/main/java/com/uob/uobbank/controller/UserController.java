package com.uob.uobbank.controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uob.uobbank.model.TransactionHistoryInput;
import com.uob.uobbank.model.TransactionModel;
import com.uob.uobbank.model.Transction;
import com.uob.uobbank.model.User;
import com.uob.uobbank.service.IUserService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RequestMapping("/users")
@RestController
public class UserController {
	@Autowired
	IUserService iUserService;
	
	@GetMapping("/test")
	public String test() {
		
		return "Welcome to UOB";
	}
	
	@PostMapping("/register")
	public ResponseEntity createUserAccount(@RequestBody User user){
		iUserService.createUserAccount(user);
		
		return new ResponseEntity("User Account Registratin Successful", HttpStatus.OK);
		
	}
	
	@PostMapping("/sendmoney")
	public ResponseEntity fundsTransfer(@RequestBody TransactionModel transaction){
		
		iUserService.fundsTransfer(transaction);
		
		return new ResponseEntity("Amount Transfred", HttpStatus.OK);
		
	}

	
	@PostMapping("/statements")
	public  List<Transction> getStatmentByMonth(@RequestBody TransactionHistoryInput transaction)throws ParseException{
		
		return iUserService.getStatementByMonth(transaction);
		
//		return new ResponseEntity("statement generated", HttpStatus.OK);
		
	}
}
