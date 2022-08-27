package com.hotelBooking.app.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "booking")
public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;

	@Column(name = "booking_status")
	private boolean booking_status;

	@Column(name = "no_of_rooms")
	private int no_of_rooms;

	@Column(name = "no_of_members")
	private int no_of_members;

	@ManyToOne
	private User user;

	@ManyToOne
	private Hotel hotel;

	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at")
	private Date created_at;

	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "modified_at")
	private Date modified_at;

	public Booking() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Booking(boolean booking_status, int no_of_rooms, int no_of_members, User user, Hotel hotel, Date created_at,
			Date modified_at) {
		super();
		this.booking_status = booking_status;
		this.no_of_rooms = no_of_rooms;
		this.no_of_members = no_of_members;
		this.user = user;
		this.hotel = hotel;
		this.created_at = created_at;
		this.modified_at = modified_at;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public boolean isBooking_status() {
		return booking_status;
	}

	public void setBooking_status(boolean booking_status) {
		this.booking_status = booking_status;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
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

	public int getNo_of_rooms() {
		return no_of_rooms;
	}

	public void setNo_of_rooms(int no_of_rooms) {
		this.no_of_rooms = no_of_rooms;
	}

	public int getNo_of_members() {
		return no_of_members;
	}

	public void setNo_of_members(int no_of_members) {
		this.no_of_members = no_of_members;
	}

}
