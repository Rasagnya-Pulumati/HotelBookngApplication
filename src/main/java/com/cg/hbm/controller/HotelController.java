package com.cg.hbm.controller;

import java.util.ArrayList;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.hbm.dto.HotelAdminResponseDTO;
import com.cg.hbm.dto.HotelDTO;

import com.cg.hbm.entity.Hotel;
import com.cg.hbm.exception.RecordNotFoundException;
import com.cg.hbm.service.IHotelService;
import com.cg.hbm.util.HotelDTOConvertor;

@RestController
@RequestMapping("/Hotel")
public class HotelController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private IHotelService hotelService;

	@Autowired
	private HotelDTOConvertor hotelDTOConvertor;

	public HotelController() {
		logger.info("Hotel booking Rest Controller called");
		System.err.println("Hotel booking Rest Controller called");
	}

	@PostMapping("/hotel")
	public ResponseEntity<?> addCourse(@RequestBody Hotel hotel) {
		Hotel savedHotel = hotelService.addHotel(hotel);

		HotelAdminResponseDTO responseDTO = hotelDTOConvertor.getHotelAdminResponseDTO(savedHotel);

		return new ResponseEntity<HotelAdminResponseDTO>(responseDTO, HttpStatus.OK);
	}

	@GetMapping("/hotels")
	public ResponseEntity<List<HotelDTO>> getAllHotel() {
		List<Hotel> allHotels = hotelService.getAllHotels(); // give us raw data (complete information , which we cannot
																// share with users directly)
		// Converting into DTO form , which we can share with user
		List<HotelDTO> allHotelDTO = new ArrayList<>();

		for (Hotel hotel : allHotels) {

			allHotelDTO.add(hotelDTOConvertor.getHotelDTO(hotel));

		}

		return new ResponseEntity<List<HotelDTO>>(allHotelDTO, HttpStatus.OK);
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<HotelDTO> getHotelById(@PathVariable int id) throws RecordNotFoundException {
		Hotel hotelFromDB = hotelService.getHotelById(id);
		HotelDTO dto = hotelDTOConvertor.getHotelDTO(hotelFromDB);

		return new ResponseEntity<HotelDTO>(dto, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<HotelDTO> deleteHotelById(@PathVariable int id) {
		Hotel hotelFromDB = hotelService.deleteHotelById(id);
		HotelDTO dto = hotelDTOConvertor.getHotelDTO(hotelFromDB);

		return new ResponseEntity<HotelDTO>(dto, HttpStatus.OK);
	}

	@PutMapping("/hotel/{id}")
	public ResponseEntity<?> updateHotel(@RequestBody Hotel hotel,@PathVariable int id) throws RecordNotFoundException {
		Hotel savedHotel = hotelService.updateHotel(id,hotel);

		HotelAdminResponseDTO responseDTO = hotelDTOConvertor.getHotelAdminResponseDTO(savedHotel);

		return new ResponseEntity<HotelAdminResponseDTO>(responseDTO, HttpStatus.OK);
	}

}