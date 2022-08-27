package com.hotelBooking.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hotelBooking.app.entity.Hotel;
import com.hotelBooking.app.entity.User;
import com.hotelBooking.app.repo.UserRepo;

@Service
public class UserService {

	@Autowired
	private UserRepo userRepo;

	// save Users
	public ResponseEntity insertUser(User user) {
		try {
			userRepo.save(user);
			return ResponseEntity.ok().body(userRepo.findAll());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Duplicate value");
		}
	}

	// get users by ID
	public ResponseEntity fetchUserById(long id) {
		if (userRepo.findById(id).isPresent()) {
			User user = userRepo.findById(id).get();
			return ResponseEntity.ok().body(user);
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User id = " + id + " doesn't exist.");
		}
	}

	// update users using ID
	public ResponseEntity updateUser(long id, User updatedUser) {
		if (userRepo.findById(id).isPresent()) {
			User existingUser = userRepo.findById(id).get();
			existingUser.setId(id);
			existingUser.setName(updatedUser.getName());
			existingUser.setPhone(updatedUser.getPhone());
			existingUser.setMail_id(updatedUser.getMail_id());
			existingUser.setCreated_at(existingUser.getCreated_at());
			userRepo.save(existingUser);
			return ResponseEntity.ok().body(userRepo.findById(id).get());
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User id = " + id + " doesn't exist for update");
		}
	}

	// delete users using ID
	public ResponseEntity removeUsers(long id) {
		if (userRepo.findById(id).isPresent()) {
			userRepo.deleteById(id);
			return ResponseEntity.status(HttpStatus.ACCEPTED).body("user id = " + id + " is removed.");
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("user id = " + id + " doesn't exist.");
		}
	}

}
