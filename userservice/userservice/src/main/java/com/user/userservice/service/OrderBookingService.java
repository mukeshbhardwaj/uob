package com.user.userservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.user.userservice.model.OrderBooking;

@Service
public interface OrderBookingService {

	public void createOrder(OrderBooking orderBooking);

	public Optional<OrderBooking> getOrder(Long bookingId);

	public List<OrderBooking> findAllBookedOrders();

//	public List<OrderBooking> findAllBookedOrdersByUserName(String userName);

}
