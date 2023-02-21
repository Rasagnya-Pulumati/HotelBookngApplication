package com.cg.hbm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.hbm.entity.BookingDetails;
@Repository
public interface IBookingDetailsRepository extends JpaRepository<BookingDetails, Integer> {

	BookingDetails findByBookingId(Integer id);
	
}
