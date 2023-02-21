package com.cg.hbm.util;

import org.springframework.stereotype.Component;


import com.cg.hbm.dto.BookingDetailsDTO;
import com.cg.hbm.dto.BookingDetailsResponseDTO;
import com.cg.hbm.entity.BookingDetails;

@Component
public class BookingDetailsDTOConvertor {
	
	public BookingDetailsResponseDTO getBookingDetailsResponseDTO(BookingDetails bookingDetails) {
	
	BookingDetailsResponseDTO dto=new BookingDetailsResponseDTO();
	dto.setBookingId(bookingDetails.getBookingId());
	
	
	dto.setBookedFrom(bookingDetails.getBookedFrom());
	dto.setBookedTo(bookingDetails.getBookedTo());
	dto.setNoOfAdults(bookingDetails.getNoOfAdults());
	dto.setNoOfChildren(bookingDetails.getNoOfChildren());
	dto.setAmount(bookingDetails.getAmount());
	dto.setMsg("Booking Saved");
	return dto;
	}
	public BookingDetailsDTO getBookingDetailsDTO(BookingDetails b)
	{
		BookingDetailsDTO obj=new BookingDetailsDTO(b.getBookingId(),b.getBookedFrom(),b.getBookedTo(),b.getNoOfAdults(),b.getNoOfChildren(),b.getAmount());
		return obj;
	}
}
	
	
	
	
	
