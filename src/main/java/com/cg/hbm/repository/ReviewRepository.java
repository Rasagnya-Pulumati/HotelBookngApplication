package com.cg.hbm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.hbm.entity.Review;
import com.cg.hbm.exception.InvalidInputDataException;

public interface ReviewRepository extends JpaRepository<Review,Integer>{

	List<Review> getReviewByStarRating(int starRating);	
	
	List<Review> getReviewByHotelId(int hotelId) throws InvalidInputDataException;
	
	List<Review> getReviewByRoomId(int roomId) throws InvalidInputDataException;

	
	//public List<Review> getAllReviews();
	
   
}
