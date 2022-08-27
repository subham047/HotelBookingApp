package com.hotelBooking.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hotelBooking.app.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
	
	@Query("SELECT t FROM User t WHERE t.phone = ?1")
    User findByPhone(Long phone);

}
