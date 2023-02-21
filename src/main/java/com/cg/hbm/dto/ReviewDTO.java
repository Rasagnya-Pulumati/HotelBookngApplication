package com.cg.hbm.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ReviewDTO {
	
	private int id;
	private String userName;
	private String userReviewMsge;
	private int starRating;
	private int hotelId;
	private int roomId;


}
