package com.cg.hbm.controller;
import java.util.ArrayList;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.hbm.dto.ReviewDTO;
import com.cg.hbm.dto.ReviewResponseDTO;
import com.cg.hbm.entity.Review;
import com.cg.hbm.exception.InvalidInputDataException;
import com.cg.hbm.service.ReviewService;
import com.cg.hbm.util.ReviewDTOConvertor;

@RestController
@RequestMapping("/review")

public class ReviewController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	ReviewService reviewService;
	
	@Autowired
	ReviewDTOConvertor reviewDTOConvertor;

	public ReviewController() {
		
	logger.info("---Review Controller Called --");
	logger.warn("---Review Controller Called --");
	
	System.err.println("Review Controller Called");
    }
	
	@PostMapping("/addReview")
	public ResponseEntity<ReviewResponseDTO> addReview(@RequestBody Review review) throws Exception
	{
		Review savedReview = reviewService.addReview(review);
		
		logger.info("---->> Review saved"+savedReview);
		
		
		if(savedReview != null) {

		ReviewResponseDTO dtoObj = reviewDTOConvertor.getReviewResponseDTO(savedReview);
		return new ResponseEntity<ReviewResponseDTO>(dtoObj,HttpStatus.OK);
	}
		return null;
			
	}
	
	
	@GetMapping("/reviews")
	public ResponseEntity<List<ReviewResponseDTO>> getAllReviews()
	{
		List<Review> allReviews = reviewService.getAllReviews();
		List<ReviewResponseDTO> allReviewDTO = new ArrayList<>();
		
		for (Review review : allReviews) {
			
			allReviewDTO.add(reviewDTOConvertor.getReviewResponseDTO(review));		
		}
		return new ResponseEntity<List<ReviewResponseDTO>>(allReviewDTO,HttpStatus.OK);
	}
	
	@GetMapping("/rating/{starRating}")
	public ResponseEntity<List<ReviewDTO>> getReviewByStarRating(@PathVariable int starRating) {
		
		List<Review> filteredReviews = reviewService.getReviewByStarRating(starRating);
		
			List<ReviewDTO> filteredReviewDTO = new ArrayList<>();
			for (Review review : filteredReviews) {
				
				filteredReviewDTO.add(reviewDTOConvertor.getReviewDTO(review));
				
			}
			return new ResponseEntity<List<ReviewDTO>>(filteredReviewDTO,HttpStatus.OK);
			
			}
		
	
	@GetMapping("/hotel/{hotelId}")
	public ResponseEntity<List<ReviewDTO>> getReviewByHotelId(@PathVariable int hotelId) throws InvalidInputDataException{
		List<Review> allReviews = reviewService.getReviewByHotelId(hotelId);
		
		if(allReviews.isEmpty())
		{
			throw new InvalidInputDataException("no review exists with this key"+hotelId);
		}
		else {
		   List<ReviewDTO> allReviewDTO = new ArrayList<>();
		
		    for (Review review : allReviews) {
			
			   allReviewDTO.add(reviewDTOConvertor.getReviewDTO(review));
		    }

			return new ResponseEntity<List<ReviewDTO>>(allReviewDTO,HttpStatus.OK);
			}			   
	}
		
	@GetMapping("/room{roomId}")
	public ResponseEntity<List<ReviewDTO>> getReviewByRoomId(@PathVariable int roomId) throws InvalidInputDataException{
		List<Review> allReviews = reviewService.getReviewByRoomId(roomId);
		
		if(allReviews.isEmpty())
		{
			throw new InvalidInputDataException("no review exists with this key"+roomId);
		}
		else {
		
		List<ReviewDTO> allReviewDTO = new ArrayList<>();
		
		for (Review review : allReviews) {
			
			allReviewDTO.add(reviewDTOConvertor.getReviewDTO(review));
			
		}
		
		return new ResponseEntity<List<ReviewDTO>>(allReviewDTO,HttpStatus.OK);
		}
	}
	}

		
	