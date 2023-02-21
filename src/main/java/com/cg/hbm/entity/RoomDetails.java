package com.cg.hbm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "MyRoomDetails")
public class RoomDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(updatable = false)
	private int roomId;
	@Column(unique = true, updatable = false)
	private String roomNo;
	private String roomType;
	private double ratePerDay;
	private boolean isAvailable;
	
	public RoomDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RoomDetails(String roomNo, String roomType, double ratePerDay, boolean isAvailable) {
		super();
		this.roomNo = roomNo;
		this.roomType = roomType;
		this.ratePerDay = ratePerDay;
		this.isAvailable = isAvailable;
	}
}