package com.cg.hbm.service;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.hbm.entity.Hotel;
import com.cg.hbm.exception.RecordNotFoundException;
import com.cg.hbm.repository.IHotelRepository;

@Service
public class HotelServiceImpl implements IHotelService {
	@Autowired
	private IHotelRepository hotelRepository;

	@Override
	public Hotel addHotel(Hotel hotel) {

		return hotelRepository.save(hotel);
	}
	
	

	@Override
	public Hotel getHotelById(int id) throws RecordNotFoundException {
		if(hotelRepository.existsById(id)) {

		return hotelRepository.getReferenceById(id);
		}
		else {
			throw new RecordNotFoundException("No hotel exists with this id = "+id);

		}
		//return null;
	}

	@Override
	public List<Hotel> getAllHotels() {

		return hotelRepository.findAll();
	}

	@Override
	public Hotel deleteHotelById(int hId) {
		Hotel savedHotel = hotelRepository.findById(hId).get();
		hotelRepository.deleteById(hId);
		return savedHotel;
	}

	@Override
		
		public Hotel updateHotel(int hId,Hotel hotel) throws RecordNotFoundException {
			//Hotel updateHotel = hotelRepository.findById(hId).get();
			if (hotelRepository.existsById(hId)) {
				return hotelRepository.save(hotel);
			}
			else {
				throw new RecordNotFoundException("Invalid Hotel details");
			}
			//return hotelRepository.save(hId);
			}

		
		
	


}

