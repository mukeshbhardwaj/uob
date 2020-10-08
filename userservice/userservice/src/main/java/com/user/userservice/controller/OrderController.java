package com.user.userservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.user.userservice.model.OrderBooking;
import com.user.userservice.service.OrderBookingService;

@RestController
@RequestMapping("/orders")
public class OrderController {
	@Autowired
	OrderBookingService orderBookingService;

	@PostMapping
	public ResponseEntity<String> createOrder(@RequestBody OrderBooking OrderBooking) {
		orderBookingService.createOrder(OrderBooking);
		
		return new ResponseEntity<String>("Booking created", HttpStatus.OK);
	}

	@GetMapping("/{bookingId}")
	public ResponseEntity<OrderBooking>  getOrderById(@PathVariable Long bookingId){
		Optional<OrderBooking> orderBooking = orderBookingService.getOrder(bookingId);
		if (orderBooking.isPresent()) {
			return new ResponseEntity<OrderBooking>(orderBooking.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<OrderBooking>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<OrderBooking>> fidAllBookingOrders(){
		List<OrderBooking> ordeList=orderBookingService.findAllBookedOrders();
		return new ResponseEntity<List<OrderBooking>>(ordeList, HttpStatus.OK);
	}
	
	/*
	 * @GetMapping("/search/username") public ResponseEntity<List<OrderBooking>>
	 * fidAllBookingOrderByUserName(@RequestParam String userName){ return new
	 * ResponseEntity<List<OrderBooking>>(orderBookingService.
	 * findAllBookedOrdersByUserName(userName), HttpStatus.OK); }
	 */
}
