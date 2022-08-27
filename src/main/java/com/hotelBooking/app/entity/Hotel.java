package com.hotelBooking.app.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "hotel")
public class Hotel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;

	@Column(name = "name", length = 30, unique = true)
	private String name;

	@Column(name = "total_rooms")
	private int total_rooms;

	@Column(name = "available_rooms")
	private int available_rooms;

	@Column(name = "wifi")
	private boolean wifi;

	@Column(name = "restaurant")
	private boolean restaurant;

	@Column(name = "ac")
	private boolean ac;

	@Column(name = "meals")
	private boolean meals;

	@Column(name = "room_price")
	private double room_price;

	@Column(name = "city")
	private String city;

	@OneToMany
	private Set<Booking> booking;

	@OneToMany
	private Set<Review> review;

	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at")
	private Date created_at;

	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "modified_at")
	private Date modified_at;

	public Hotel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Hotel(String name, int total_rooms, int available_rooms, boolean wifi, boolean restaurant, boolean ac,
			boolean meals, double room_price, String city, Set<Booking> booking, Set<Review> review, Date created_at,
			Date modified_at) {
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
		this.booking = booking;
		this.review = review;
		this.created_at = created_at;
		this.modified_at = modified_at;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public Set<Booking> getBooking() {
		return booking;
	}

	public void setBooking(Set<Booking> booking) {
		this.booking = booking;
	}

	public Set<Review> getReview() {
		return review;
	}

	public void setReview(Set<Review> review) {
		this.review = review;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	public Date getModified_at() {
		return modified_at;
	}

	public void setModified_at(Date modified_at) {
		this.modified_at = modified_at;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

}
