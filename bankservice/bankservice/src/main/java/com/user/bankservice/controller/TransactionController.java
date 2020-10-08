package com.user.bankservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.bankservice.model.TransactionModel;
import com.user.bankservice.service.IUserService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/payment")
public class TransactionController {

	@Autowired
	IUserService iUserService;

	@PostMapping("/itemprice")
	public ResponseEntity<String> payNow(@RequestBody TransactionModel transaction) {
//		public ResponseEntity payNow(@RequestBody TransactionModel, transaction,price, venodraccount)
//		iUserService.payment(transaction,amount,bookingid);
		iUserService.fundsTransfer(transaction);

		return new ResponseEntity<>("Payment Successfull", HttpStatus.OK);
	}

}
