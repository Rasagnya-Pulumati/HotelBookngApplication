package com.cg.hbm.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingDetailsDTO {

	private int bookingId;
	
	private Date bookedFrom;
	private Date bookedTo;
	private int noOfAdults;
	private int noOfChildren;
	private double amount;
}