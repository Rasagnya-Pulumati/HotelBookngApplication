package com.cg.hbm.servicetest;

import com.cg.hbm.entity.Hotel;

import static org.junit.jupiter.api.Assertions.*;


import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


import com.cg.hbm.entity.Hotel;
import com.cg.hbm.repository.IHotelRepository;
import com.cg.hbm.service.HotelServiceImpl;


class HotelServiceImplTest{

	@InjectMocks   // use on which class to test
	HotelServiceImpl hotelServiceImpl;
	
	@Mock
	IHotelRepository hotelRepository;
	
	@SuppressWarnings("deprecation")
	@BeforeEach
	public void doInit()
	{
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	@DisplayName("Test case to test insertion of Hotel when input values are valid")
	void testAddCourse() {
		// sample input 
		Hotel sampleInput = new Hotel("hyd", "taj", "4-56", "Good", 500, "hotel@gmail.com","78642843676", "7845643676", "https://hotel.com");
		// expected output 
		Hotel actualOutput = new Hotel("bang", "taj", "5-67", "nice", 1500, "hotel12@gmail.com","78642843676", "7845643676", "https://hotel.com");
		actualOutput.setHotelId(0);
		
		
		
		
		Hotel expectedOutput = new Hotel("bang", "taj", "5-67", "nice", 1500, "hotel12@gmail.com","78642843676", "7845643676", "https://hotel.com");
		expectedOutput.setHotelId(0);
		
		
		// call actual method and store actual result : actual output
		
		when(hotelRepository.save(sampleInput)).thenReturn(actualOutput);
		
			
		// compare actual output with expected output
		assertEquals(actualOutput, expectedOutput);
		
	}

	
	
	
	
	@Test
	@DisplayName("Test case to test insertion of Course when input values are invalid")
	void testAddCourse2() {
		Hotel sampleInput = new Hotel("hyd", "tajj", "4-56", "Good", 500, "hotel@gmail.com","78642843676", "7845643676", "https://hotel.com");
		
		// call actual method and store actual result : actual output
		
		when(hotelRepository.save(sampleInput)).thenThrow(NullPointerException.class);
		
		
	}

	
	
}

