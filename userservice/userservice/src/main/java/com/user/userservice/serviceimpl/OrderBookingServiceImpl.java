package com.user.userservice.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.userservice.model.OrderBooking;
import com.user.userservice.repo.OrderBookingServiceRepo;
import com.user.userservice.service.OrderBookingService;

@Service
public class OrderBookingServiceImpl implements OrderBookingService {
@Autowired
	OrderBookingServiceRepo orderBookingServiceRepo;
	@Override
	public void createOrder(OrderBooking orderBooking) {
		
		orderBookingServiceRepo.save(orderBooking)	;	
	}
	@Override
	public Optional<OrderBooking> getOrder(Long bookingId) {

		return orderBookingServiceRepo.findById(bookingId);
		
	}
	@Override
	public List<OrderBooking> findAllBookedOrders() {
		return orderBookingServiceRepo.findAll();		
	}
//	@Override
//	public List<OrderBooking> findAllBookedOrdersByUserName(String userName) {
//
//		return orderBookingServiceRepo.findAllByUserName(userName);
//		
//	}

}
