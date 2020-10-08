package com.zuul.apigayway.zullapigatway.feignclient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.zuul.apigayway.zullapigatway.model.OrderBooking;

@FeignClient(name="http://USER-SERVICE/order/")
public interface UserOrderFeignClient {

	@PostMapping
	public ResponseEntity<String> createOrder(@RequestBody OrderBooking OrderBooking);
	
	@GetMapping("/{bookingId}")
	public ResponseEntity<OrderBooking>  getOrderById(@PathVariable("bookingId") Long bookingId);
	
	@GetMapping("/allorders")
	public ResponseEntity<List<OrderBooking>> fidAllBookingOrders();
	
}
