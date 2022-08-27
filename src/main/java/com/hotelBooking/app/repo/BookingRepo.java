package com.hotelBooking.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hotelBooking.app.entity.Booking;

@Repository
public interface BookingRepo extends JpaRepository<Booking, Long> {

}
