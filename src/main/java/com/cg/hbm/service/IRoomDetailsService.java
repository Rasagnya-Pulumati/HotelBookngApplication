package com.cg.hbm.service;

import java.util.List;


import org.springframework.stereotype.Service;

import com.cg.hbm.entity.RoomDetails;
import com.cg.hbm.exception.RoomDetailsIdNotFoundException;
@Service
public interface IRoomDetailsService {

	public RoomDetails addRoomDetails(RoomDetails roomDetails) throws RoomDetailsIdNotFoundException;
	
	public RoomDetails updateRoomDetails(RoomDetails roomDetails) throws RoomDetailsIdNotFoundException;
	
	public RoomDetails removeRoomDetails(int roomDetails) throws RoomDetailsIdNotFoundException;
	
	public List<RoomDetails> showAllRoomDetails() throws RoomDetailsIdNotFoundException;
	
	public RoomDetails showRoomDetails(int roomDetailsId) throws RoomDetailsIdNotFoundException;

	
}