package com.hotelBooking.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hotelBooking.app.entity.Hotel;
import com.hotelBooking.app.entity.Review;
import com.hotelBooking.app.entity.User;
import com.hotelBooking.app.repo.HotelRepo;
import com.hotelBooking.app.repo.ReviewRepo;
import com.hotelBooking.app.repo.UserRepo;

@Service
public class ReviewService {

	@Autowired
	private ReviewRepo reviewRepo;

	@Autowired
	private HotelRepo hotelRepo;

	@Autowired
	private UserRepo userRepo;

	public ResponseEntity addReview(long hotel_id, long user_id, Review review) {
		if(review.getRatings()<=10) {
			if (hotelRepo.findById(hotel_id).isPresent() && userRepo.findById(user_id).isPresent()) {
				Hotel hotel = hotelRepo.findById(hotel_id).get();
				User user = userRepo.findById(user_id).get();
				
				review.setHotel(hotel);
				review.setUser(user);
				
				reviewRepo.save(review);
				return ResponseEntity.ok().body(reviewRepo.findAll());
			} else {
				return ResponseEntity.ok().body("Hotel or User not available in Database");
			}			
		}else {
			return ResponseEntity.ok().body("Give Ratings out of 10");
		}

	}

	public ResponseEntity getReview(long review_id) {
		return ResponseEntity.ok().body(reviewRepo.findById(review_id).get());
	}

	public ResponseEntity updateReview(long review_id, long user_id, Review review) {
		if(review.getRatings()<=10) {
			if (reviewRepo.findById(review_id).isPresent()
					&& (reviewRepo.findById(review_id).get().getUser().getId() == user_id)) {
				Review existigReview = reviewRepo.findById(review_id).get();
				existigReview.setId(review_id);
				existigReview.setReview(review.getReview());
				existigReview.setRatings(review.getRatings());
				reviewRepo.save(existigReview);
				return ResponseEntity.ok().body(reviewRepo.findById(review_id).get());
			} else {
				return ResponseEntity.ok().body(
						"User doesn't have the authority to update this review or This review doesn't exist in Database.");
			}			
		}else {
			return ResponseEntity.ok().body("Give Ratings out of 10");
		}
	}

	public ResponseEntity deleteReview(long review_id, long user_id) {
		if (reviewRepo.findById(review_id).isPresent()
				&& (reviewRepo.findById(review_id).get().getUser().getId() == user_id)) {
			reviewRepo.deleteById(review_id);
			return ResponseEntity.ok().body("Review successfully removed");
		} else {
			return ResponseEntity.ok()
					.body("User doesn't have the authority to update this review or This review already got removed.");
		}
	}

}
