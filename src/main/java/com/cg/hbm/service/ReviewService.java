package com.cg.hbm.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.hbm.entity.Review;
import com.cg.hbm.exception.InvalidInputDataException;


@Service
public interface ReviewService {
	
	
	    public List<Review> getAllReviews();
	    public Review addReview(Review review) throws Exception;
	 	
		public List<Review> getReviewByHotelId(int hotelId) throws InvalidInputDataException;

		public List<Review> getReviewByRoomId(int roomId) throws InvalidInputDataException;
		
		public List<Review> getReviewByStarRating(int starRating);

	
}


