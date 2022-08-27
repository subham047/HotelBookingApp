package com.hotelBooking.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotelBooking.app.entity.Hotel;
import com.hotelBooking.app.service.HotelService;

@RestController
@RequestMapping("hotelBookingApp")
public class HotelController {

	@Autowired
	private HotelService hotelService;

	// save hotels
	@PostMapping("add/hotels")
	public ResponseEntity<List<Hotel>> saveData(@RequestBody Hotel hotel) {
		return hotelService.insertHotel(hotel);
	}

	// get hotels by ID
	@GetMapping("get/hotels/{id}")
	public ResponseEntity getHotelById(@PathVariable long id) {
		return hotelService.fetchHotelById(id);
	}

	// update hotels
	@PutMapping("update/hotel/{id}")
	public ResponseEntity updateHotel(@PathVariable long id, @RequestBody Hotel hotel) {
		return hotelService.updateHotel(id, hotel);
	}

	// delete hotels
	@DeleteMapping("delete/hotel/{id}")
	public ResponseEntity deleteHotelById(@PathVariable long id) {
		return hotelService.removeHotels(id);
	}
	
	//ivjvij
	@GetMapping("get")
	public ResponseEntity getData() {
		return hotelService.getdata();
	}

}
