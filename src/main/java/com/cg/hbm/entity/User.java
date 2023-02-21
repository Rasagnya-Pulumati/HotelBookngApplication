package com.cg.hbm.entity;

import javax.persistence.CascadeType;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="users")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(updatable = false)
	private int userId;
	
	@Column(name = "user_name",unique = true, updatable = false)
	
	private String userName;
	
	@Column(name = "email_address",unique = true,nullable = false)
	private String email;
	
	
	private String password;
	
	
	private String mobile;
	
	
	private String address;
	
	@OneToOne(cascade = CascadeType.ALL)
	private BookingDetails booking;
	
	public User(int userId) {
		this.userId = userId;
	}
	
	
}
