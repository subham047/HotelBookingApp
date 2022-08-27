package com.hotelBooking.app.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hotelBooking.app.dto.HotelDto;
import com.hotelBooking.app.entity.Hotel;
import com.hotelBooking.app.repo.HotelRepo;

@Service
public class HotelService {

	@Autowired
	private HotelRepo hotelRepo;

	@Autowired
	private EntityManager emn;

	// save Hotels
	public ResponseEntity insertHotel(Hotel hotel) {
		try {
			hotelRepo.save(hotel);
			return ResponseEntity.ok().body(hotelRepo.findAll());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Duplicate Value. Hotel can't be inserted");
		}
	}

	// get hotels by ID
	public ResponseEntity fetchHotelById(long id) {
		if (hotelRepo.findById(id).isPresent()) {
			Hotel hotel = hotelRepo.findById(id).get();
			return ResponseEntity.ok().body(hotel);
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("hotel id = " + id + " doesn't exist.");
		}
	}

	public ResponseEntity<List<HotelDto>> getdata() {

		String query = "select name from Hotel a\n" + "join Review b on a.id=b.hotel_id";
		Query obj = emn.createQuery(query);
		List<Object[]> hotelList = obj.getResultList();
		List<HotelDto> hotelDto = new ArrayList<HotelDto>();

		for (Object[] hotel : hotelList) {
			HotelDto hoteldto1 = new HotelDto();
			System.out.println(hotel[1] + " - - " + hotel[2] + " - - " + hotel[3]);

			hotelDto.add(hoteldto1);
		}
		return ResponseEntity.ok().body(hotelDto);
	}

	// update hotels using ID
	public ResponseEntity updateHotel(long id, Hotel updatedHotel) {
		if (hotelRepo.findById(id).isPresent()) {
			Hotel existingHotel = hotelRepo.findById(id).get();
			existingHotel.setId(id);
			existingHotel.setName(updatedHotel.getName());
			existingHotel.setTotal_rooms(updatedHotel.getTotal_rooms());
			existingHotel.setAvailable_rooms(updatedHotel.getAvailable_rooms());
			existingHotel.setWifi(updatedHotel.isWifi());
			existingHotel.setRestaurant(updatedHotel.isRestaurant());
			existingHotel.setAc(updatedHotel.isAc());
			existingHotel.setMeals(updatedHotel.isMeals());
			existingHotel.setRoom_price(updatedHotel.getRoom_price());
			existingHotel.setCreated_at(existingHotel.getCreated_at());
			hotelRepo.save(existingHotel);
			return ResponseEntity.ok().body(hotelRepo.findById(id).get());
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("hotel id = " + id + " doesn't exist for update");
		}
	}

	// delete hotels using ID
	public ResponseEntity removeHotels(long id) {
		if (hotelRepo.findById(id).isPresent()) {
			hotelRepo.deleteById(id);
			return ResponseEntity.status(HttpStatus.ACCEPTED).body("hotel id = " + id + " is removed.");
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("hotel id = " + id + " doesn't exist.");
		}
	}

}
