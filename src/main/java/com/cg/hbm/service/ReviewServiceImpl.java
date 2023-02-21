package com.cg.hbm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.hbm.entity.Review;
import com.cg.hbm.exception.InvalidInputDataException;
import com.cg.hbm.repository.ReviewRepository;

@Service
public class ReviewServiceImpl implements ReviewService{
	
	@Autowired
	ReviewRepository reviewRepository;
	
	@Override
	public List<Review> getAllReviews() {
		
		return reviewRepository.findAll();	
	}

	@Override
	public Review addReview(Review review) {
	
		return reviewRepository.save(review);
	}
	
	@Override
	public List<Review> getReviewByStarRating(int starRating){
		
		
		return reviewRepository.getReviewByStarRating(starRating);
	}

	
	@Override
	public List<Review> getReviewByHotelId(int hotelId) throws InvalidInputDataException {
		
		if(reviewRepository.existsById(hotelId)) {
		return reviewRepository.getReviewByHotelId(hotelId);
		}
		else {
			throw new InvalidInputDataException("No review exists with this key = "+hotelId);
		}
		
	}
	
	@Override
	public List<Review> getReviewByRoomId(int roomId) throws InvalidInputDataException {
		
		if(reviewRepository.existsById(roomId)) {
			return reviewRepository.getReviewByRoomId(roomId);
			}
			else {
				throw new InvalidInputDataException("No review exists with this key = "+roomId);
			}
	}
	
	
}
