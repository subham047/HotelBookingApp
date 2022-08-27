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
import com.hotelBooking.app.entity.User;
import com.hotelBooking.app.service.UserService;

@RestController
@RequestMapping("hotelBookingApp")
public class UserController {

	@Autowired
	private UserService userService;

	// save Users
	@PostMapping("add/users")
	public ResponseEntity<List<User>> addUser(@RequestBody User user) {
		return userService.insertUser(user);
	}

	// get Users by ID
	@GetMapping("get/users/{id}")
	public ResponseEntity getUserById(@PathVariable long id) {
		return userService.fetchUserById(id);
	}

	// update users
	@PutMapping("update/users/{id}")
	public ResponseEntity updateUser(@PathVariable long id, @RequestBody User user) {
		return userService.updateUser(id, user);
	}

	// delete users
	@DeleteMapping("delete/users/{id}")
	public ResponseEntity deleteHotelById(@PathVariable long id) {
		return userService.removeUsers(id);
	}

}
