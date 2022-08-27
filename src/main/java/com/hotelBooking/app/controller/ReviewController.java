package com.hotelBooking.app.controller;

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

import com.hotelBooking.app.entity.Review;
import com.hotelBooking.app.service.ReviewService;

@RestController
@RequestMapping("hotelBookingApp")
public class ReviewController {

	@Autowired
	private ReviewService reviewService;

	@PostMapping("add/review/hotel/{hotel_id}/user/{user_id}")
	public ResponseEntity addReview(@PathVariable long hotel_id, @PathVariable long user_id,
			@RequestBody Review review) {
		return reviewService.addReview(hotel_id, user_id, review);
	}

	@GetMapping("get/review/{review_id}")
	public ResponseEntity getReview(@PathVariable long review_id) {
		return reviewService.getReview(review_id);
	}

	@PutMapping("update/review/{review_id}/user/{user_id}")
	public ResponseEntity updateReview(@PathVariable long review_id, @PathVariable long user_id,
			@RequestBody Review review) {
		return reviewService.updateReview(review_id, user_id, review);
	}

	@DeleteMapping("delete/review/{review_id}/user/{user_id}")
	public ResponseEntity deleteReview(@PathVariable long review_id, @PathVariable long user_id) {
		return reviewService.deleteReview(review_id, user_id);
	}

}
