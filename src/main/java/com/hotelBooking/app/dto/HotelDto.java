package com.hotelBooking.app.dto;

public class HotelDto {

	private String name;

	private int total_rooms;

	private int available_rooms;

	private boolean wifi;

	private boolean restaurant;

	private boolean ac;

	private boolean meals;

	private double room_price;

	private String city;

	private String review;

	private int ratings;

	public HotelDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HotelDto(String name, int total_rooms, int available_rooms, boolean wifi, boolean restaurant, boolean ac,
			boolean meals, double room_price, String city, String review, int ratings) {
		super();
		this.name = name;
		this.total_rooms = total_rooms;
		this.available_rooms = available_rooms;
		this.wifi = wifi;
		this.restaurant = restaurant;
		this.ac = ac;
		this.meals = meals;
		this.room_price = room_price;
		this.city = city;
		this.review = review;
		this.ratings = ratings;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTotal_rooms() {
		return total_rooms;
	}

	public void setTotal_rooms(int total_rooms) {
		this.total_rooms = total_rooms;
	}

	public int getAvailable_rooms() {
		return available_rooms;
	}

	public void setAvailable_rooms(int available_rooms) {
		this.available_rooms = available_rooms;
	}

	public boolean isWifi() {
		return wifi;
	}

	public void setWifi(boolean wifi) {
		this.wifi = wifi;
	}

	public boolean isRestaurant() {
		return restaurant;
	}

	public void setRestaurant(boolean restaurant) {
		this.restaurant = restaurant;
	}

	public boolean isAc() {
		return ac;
	}

	public void setAc(boolean ac) {
		this.ac = ac;
	}

	public boolean isMeals() {
		return meals;
	}

	public void setMeals(boolean meals) {
		this.meals = meals;
	}

	public double getRoom_price() {
		return room_price;
	}

	public void setRoom_price(double room_price) {
		this.room_price = room_price;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public int getRatings() {
		return ratings;
	}

	public void setRatings(int ratings) {
		this.ratings = ratings;
	}

}
