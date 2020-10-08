package com.zuul.apigayway.zullapigatway.model;

import java.time.LocalDate;

public class OrderBooking {

	private Long bookingId;
	private Long itemId;
	private LocalDate bookingDate;
	private double amount;
	private String userName;
	private Long userId;
	
	public OrderBooking() {}


	public OrderBooking(Long bookingId, Long itemId, LocalDate bookingDate, double amount, String userName,
			Long userId) {
		super();
		this.bookingId = bookingId;
		this.itemId = itemId;
		this.bookingDate = bookingDate;
		this.amount = amount;
		this.userName = userName;
		this.userId = userId;
	}


	public Long getBookingId() {
		return bookingId;
	}

	public void setBookingId(Long bookingId) {
		this.bookingId = bookingId;
	}

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public LocalDate getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(LocalDate bookingDate) {
		this.bookingDate = bookingDate;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	
}
