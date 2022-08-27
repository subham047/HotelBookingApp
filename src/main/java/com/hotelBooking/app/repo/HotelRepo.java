package com.hotelBooking.app.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hotelBooking.app.entity.Hotel;

@Repository
public interface HotelRepo extends JpaRepository<Hotel, Long> {

	@Query("SELECT t FROM Hotel t WHERE t.name = ?1")
    Hotel findByName(String name);
	
//	@Query("SELECT a from Hotel a join Review b on a.id=b.id")
//	List<Hotel> findAllDetails();
	
	
	
}
