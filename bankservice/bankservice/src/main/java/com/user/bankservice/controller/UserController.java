package com.user.bankservice.controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.bankservice.model.TransactionHistoryInput;
import com.user.bankservice.model.TransactionModel;
import com.user.bankservice.model.Transction;
import com.user.bankservice.model.User;
import com.user.bankservice.service.IUserService;

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
	public ResponseEntity<String> createUserAccount(@RequestBody User user){
		iUserService.createUserAccount(user);
		
		return new ResponseEntity<>("User Account Registratin Successful", HttpStatus.OK);
		
	}
	
	@PostMapping("/sendmoney")
	public ResponseEntity<String> fundsTransfer(@RequestBody TransactionModel transaction){
		
		iUserService.fundsTransfer(transaction);
		
		return new ResponseEntity<>("Amount Transfred", HttpStatus.OK);
		
	}

	
	@PostMapping("/statements")
	public  List<Transction> getStatmentByMonth(@RequestBody TransactionHistoryInput transaction)throws ParseException{
		
		return iUserService.getStatementByMonth(transaction);
		
//		return new ResponseEntity("statement generated", HttpStatus.OK);
		
	}
}
