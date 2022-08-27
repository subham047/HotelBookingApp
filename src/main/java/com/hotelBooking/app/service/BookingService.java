package com.hotelBooking.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.hotelBooking.app.entity.Booking;
import com.hotelBooking.app.entity.Hotel;
import com.hotelBooking.app.entity.User;
import com.hotelBooking.app.repo.BookingRepo;
import com.hotelBooking.app.repo.HotelRepo;
import com.hotelBooking.app.repo.UserRepo;

@Service
public class BookingService {

	@Autowired
	private BookingRepo bookingRepo;

	@Autowired
	private HotelRepo hotelRepo;

	@Autowired
	private UserRepo userRepo;

	public ResponseEntity bookHotel(Booking booking, long hotel_id, long user_id) {
		Hotel hotel = hotelRepo.findById(hotel_id).get();
		User userDetails = userRepo.findById(user_id).get();
		if (hotel.getAvailable_rooms() < booking.getNo_of_rooms()) {
			return ResponseEntity.ok().body("Room Not available");
		} else {
			booking.setHotel(hotel);
			booking.setUser(userDetails);
			bookingRepo.save(booking);
			hotel.setAvailable_rooms(hotel.getAvailable_rooms() - booking.getNo_of_rooms());
			hotelRepo.save(hotel);
			return ResponseEntity.ok().body(bookingRepo.findAll());
		}
	}

	public ResponseEntity<Booking> getBookingDetails(long booking_id) {
		return ResponseEntity.ok().body(bookingRepo.findById(booking_id).get());
	}

	public ResponseEntity updateBookingDetails(long booking_id, Booking booking) {
		Booking existingBooking = bookingRepo.findById(booking_id).get();
		Hotel hotel = existingBooking.getHotel();
		if (booking.isBooking_status() == false) {
			hotel.setAvailable_rooms(hotel.getAvailable_rooms() + existingBooking.getNo_of_rooms());
			existingBooking.setBooking_status(booking.isBooking_status());
			bookingRepo.save(existingBooking);
			return ResponseEntity.ok().body("Booking Cancelled Successfully");
		} else {
			existingBooking.setId(booking_id);
			existingBooking.setNo_of_members(booking.getNo_of_members());
			if (existingBooking.getNo_of_rooms() > booking.getNo_of_rooms()) {
				int cancelledRooms = existingBooking.getNo_of_rooms() - booking.getNo_of_rooms();
				hotel.setAvailable_rooms(hotel.getAvailable_rooms() + cancelledRooms);
			} else if (existingBooking.getNo_of_rooms() < booking.getNo_of_rooms()) {
				int extraRooms = booking.getNo_of_rooms() - existingBooking.getNo_of_rooms();
				if (hotel.getAvailable_rooms() >= extraRooms) {
					hotel.setAvailable_rooms(hotel.getAvailable_rooms() - extraRooms);
				} else {
					return ResponseEntity.ok().body("Room Not available");
				}
			}
			existingBooking.setNo_of_rooms(booking.getNo_of_rooms());
			existingBooking.setCreated_at(existingBooking.getCreated_at());
			existingBooking.setBooking_status(booking.isBooking_status());
			bookingRepo.save(existingBooking);
		}
		hotelRepo.save(hotel);
		return ResponseEntity.ok().body(bookingRepo.findById(booking_id).get());
	}

}
