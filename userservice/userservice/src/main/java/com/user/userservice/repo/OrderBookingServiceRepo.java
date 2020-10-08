package com.user.userservice.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.user.userservice.model.OrderBooking;

public interface OrderBookingServiceRepo extends JpaRepository<OrderBooking, Long>{

//	List<OrderBooking> findAllByUserName(String userName);
	
}
