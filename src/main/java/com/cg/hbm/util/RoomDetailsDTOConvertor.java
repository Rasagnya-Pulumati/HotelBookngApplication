package com.cg.hbm.util;

import org.springframework.stereotype.Component;

import com.cg.hbm.dto.RoomDetailsAdminResponseDTO;
import com.cg.hbm.dto.RoomDetailsDTO;
import com.cg.hbm.entity.RoomDetails;
@Component
public class RoomDetailsDTOConvertor {
	public RoomDetailsAdminResponseDTO getRoomDetailsAdminResponseDTO(RoomDetails roomDetails)
	{
		RoomDetailsAdminResponseDTO dto = new RoomDetailsAdminResponseDTO();
		dto.setRoomId(roomDetails.getRoomId());
		dto.setRoomNo(roomDetails.getRoomNo());
		dto.setRoomType(roomDetails.getRoomType());
		dto.setRatePerDay(roomDetails.getRatePerDay());
		dto.setMsg("roomDetails saved");
		return dto;
	}
	public RoomDetailsDTO getRoomDetailsDTO(RoomDetails r)
	{
		RoomDetailsDTO obj= new RoomDetailsDTO(r.getRoomId(), r.getRoomNo(),r.getRoomType(),r.getRatePerDay());
		return obj;
	}

	
	
}