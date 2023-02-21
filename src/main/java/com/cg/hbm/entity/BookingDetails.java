package com.cg.hbm.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor

public class BookingDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) // code to generate PK automatically
	
	
	
	private int bookingId;
	private int hotelId;
	private int roomId;
	private int userId;
	private Date bookedFrom;
	private Date bookedTo;
	private int noOfAdults;
	private int noOfChildren;
	private double amount;
	public BookingDetails(int bookingId, int hotelId, int roomId, int userId, Date bookedFrom, Date bookedTo,
			int noOfAdults, int noOfChildren, double amount) {
		super();
		this.bookingId = bookingId;
		this.hotelId = hotelId;
		this.roomId = roomId;
		this.userId = userId;
		this.bookedFrom = bookedFrom;
		this.bookedTo = bookedTo;
		this.noOfAdults = noOfAdults;
		this.noOfChildren = noOfChildren;
		this.amount = amount;
	}
	
	
	
	
	
}
