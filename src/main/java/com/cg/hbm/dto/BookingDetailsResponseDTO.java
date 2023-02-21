package com.cg.hbm.dto;

import java.util.Date;

import lombok.Data;

@Data
public class BookingDetailsResponseDTO {
	private int bookingId;
	
	private Date bookedFrom;
	private Date bookedTo;
	private int noOfAdults;
	private int noOfChildren;
	private double amount;
	private String msg;
}
