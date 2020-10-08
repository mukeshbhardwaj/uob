package com.zuul.apigayway.zullapigatway.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.zuul.apigayway.zullapigatway.model.TransactionModel;

@FeignClient(name="http://TRANSACTION-SERVICE/payment")
public interface FundTransferFeignClient {

	@PostMapping("/itemprice")
	public ResponseEntity payNow(@RequestBody TransactionModel transaction);
}
