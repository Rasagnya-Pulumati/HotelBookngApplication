package com.cg.hbm.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.hbm.entity.Hotel;
@Repository


public interface IHotelRepository extends JpaRepository<Hotel,Integer> {
    //public Hotel findByHotelId(int hotelId);

	public Hotel save(int hotelId);
}
