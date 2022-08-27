package com.hotelBooking.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hotelBooking.app.entity.Review;

@Repository
public interface ReviewRepo extends JpaRepository<Review, Long> {

}
