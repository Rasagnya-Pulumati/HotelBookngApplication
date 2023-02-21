package com.cg.hbm.service;


	
import java.util.List;


import org.springframework.stereotype.Service;

import com.cg.hbm.entity.Hotel;
import com.cg.hbm.exception.RecordNotFoundException;


@Service

public interface IHotelService {

	public Hotel addHotel(Hotel hotel);

	public List<Hotel> getAllHotels() ;

	public Hotel getHotelById(int id) throws RecordNotFoundException;

	public Hotel deleteHotelById(int hId);

	

	//public Hotel updateHotel(int id) throws RecordNotFoundException;

	Hotel updateHotel(int hId, Hotel hotel) throws RecordNotFoundException;

	

	}


