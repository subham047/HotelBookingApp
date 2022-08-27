package com.hotelBooking.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotelBooking.app.entity.Booking;
import com.hotelBooking.app.service.BookingService;

@RestController
@RequestMapping("hotelBookingApp")
public class BookingController {

	@Autowired
	private BookingService bookingService;

	// Book Hotels
	@PostMapping("book/hotels/{hotel_id}/user/{user_id}")
	public ResponseEntity bookHotel(@RequestBody Booking booking, @PathVariable long hotel_id, @PathVariable long user_id) {
		return bookingService.bookHotel(booking,hotel_id,user_id);
	}

	// Fetch Booking Details
	@GetMapping("get/booking_details/{booking_id}")
	public ResponseEntity<Booking> getBookingDetails(@PathVariable long booking_id){
		return bookingService.getBookingDetails(booking_id);
	}
	
	// Update Booking Details
	@PutMapping("update/booking_details/{booking_id}")
	public ResponseEntity updateBookingDetails(@PathVariable long booking_id, @RequestBody Booking booking){
		return bookingService.updateBookingDetails(booking_id,booking);
	}

}
