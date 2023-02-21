package com.cg.hbm.util;

import org.springframework.stereotype.Component;

import com.cg.hbm.dto.HotelAdminResponseDTO;
import com.cg.hbm.dto.HotelDTO;
import com.cg.hbm.entity.Hotel;

@Component
public class HotelDTOConvertor {
	
	
	public HotelAdminResponseDTO getHotelAdminResponseDTO(Hotel hotel) {
		HotelAdminResponseDTO dto=new HotelAdminResponseDTO();
		dto.setHotelId(hotel.getHotelId());
		dto.setHotelName(hotel.getHotelName());
		dto.setAddress(hotel.getAddress());
		dto.setCity(hotel.getCity());
		dto.setMsg("Hotel Saved");
		return dto;
		
		
	}
	
	public HotelDTO getHotelDTO(Hotel h){
		HotelDTO obj= new HotelDTO(h.getHotelId(),h.getHotelName(),h.getAddress(),h.getCity());
		return obj;
		
		
	}

	
	
}
