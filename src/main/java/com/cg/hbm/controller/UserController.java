package com.cg.hbm.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.hbm.entity.BookingDetails;
import com.cg.hbm.entity.User;
import com.cg.hbm.exception.BookingDetailsNotFoundException;
import com.cg.hbm.exception.RecordNotFoundException;
import com.cg.hbm.repository.UserRepository;
import com.cg.hbm.service.BookingDetailsImpl;
import com.cg.hbm.service.HotelServiceImpl;
import com.cg.hbm.service.RoomDetailsServiceImpl;
import com.cg.hbm.service.UserServiceImpl;
@RestController
@RequestMapping("/user")
public class UserController {
	private int validUser = 0;
	private Integer validId = 0;
	private String welcome = "Welcome \n........................\n User Id : ";
	@Autowired
	private UserServiceImpl userServiceImpl;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BookingDetailsImpl bookingDetailsServiceImpl;

	@Autowired
	private HotelServiceImpl hotelServiceImpl;

	@Autowired
	private RoomDetailsServiceImpl roomDetailsServiceImpl;

	@PostMapping("/createUser")
	public ResponseEntity<User> createUser(@RequestBody User user){
		User u=userServiceImpl.addUser(user);
		return new ResponseEntity<User>(u,HttpStatus.CREATED);
	}


	@PutMapping("/updateUser")
	public ResponseEntity<User> updateUser(@RequestBody User user) throws RecordNotFoundException{
		Integer id=user.getUserId();
		if(userRepository.findById(id).isPresent())
		{
			return new ResponseEntity<User>(userServiceImpl.updateUser(user),HttpStatus.CREATED);
		}
		else {
			throw new RecordNotFoundException("User with Id : "+id+" not found ");
		}
	}

	@GetMapping("/listUser")
	public List<User> getAllUsers(){
		return userServiceImpl.showAllUsers();
	}


	@DeleteMapping("/deletedById/{user_id}")
	public ResponseEntity<String> deleteUserById(@PathVariable int user_id) throws RecordNotFoundException{

		if(userRepository.findById(user_id).isPresent()) {
			String user=userServiceImpl.removeUserById(user_id);
			return new ResponseEntity<String>(user,HttpStatus.OK);
		}
		else {
			throw new RecordNotFoundException("User with Id : "+user_id+" not found ");
		}
	}


	@GetMapping("/getById/{user_id}")
	public ResponseEntity<User> getUserById(@PathVariable int user_id) throws RecordNotFoundException{

		if(userRepository.findById(user_id).isPresent()) {
			User user=userServiceImpl.showUserById(user_id);
			return new ResponseEntity<User>(user,HttpStatus.OK);
		}
		else {
			throw new RecordNotFoundException("User with Id : "+user_id+" not found ");
		}
	}

	@PostMapping(value = "/booking", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> saveOrder(@RequestBody BookingDetails booking) throws RecordNotFoundException, BookingDetailsNotFoundException{
		if(validUser == 1) {
			User user = userServiceImpl.showUserById(validId);
			//booking.setUsers(user);
			return ResponseEntity.ok(bookingDetailsServiceImpl.addBookingDetails(booking));
		}else
			return ResponseEntity.ok("Not Logged In");
	}


	@GetMapping("/login/{username}/{password}")
	public ResponseEntity<?> validateUser(@PathVariable("username") String username, @PathVariable("password") String password) {
		boolean value = userServiceImpl.validateUser(username, password);		
		if (value == true) {
			validUser = 1;
			User user = userServiceImpl.viewByUserName(username, password).get();
			validId = user.getUserId();

			return ResponseEntity.ok(welcome + validId + 
					"\n User Name : " + user.getUserName() + 
					"\n Email : " + user.getEmail() + 
					"\n Address : "+ user.getAddress());
		}
		else
			return ResponseEntity.ok("Invalid Credentials");		
	}

	@GetMapping("/booking/{id}")
	public ResponseEntity<?> viewBookingDetails(@PathVariable("id") Integer booking_id) throws RecordNotFoundException, BookingDetailsNotFoundException {
		if(validUser == 1) {
			BookingDetails booking =  bookingDetailsServiceImpl.getBookingDetailsBybookingId(booking_id);
			return ResponseEntity.ok("..........................Booking Details......................... \n " +
					"Booking id : " + booking.getBookingId() + "\n" +
					"From date : " + booking.getBookedFrom() + "\n" +
					"To date : " + booking.getBookedTo() + "\n" +
					"No Of Adults : " + booking.getNoOfAdults() + "\n" +
					"No Of Children : " + booking.getNoOfChildren() + "\n" +
					"Hotel : " + booking.getHotelId() + "\n" +
					"Room : " + booking.getRoomId() + "\n" 
					); 
		}else
			return ResponseEntity.ok("Not Logged In");

	}	

	@GetMapping("/logout")
	public ResponseEntity<?> logout(){
		if(validUser == 1) {
			validUser = 0;
			return ResponseEntity.ok("Logged out...");		
		}else
			return ResponseEntity.ok("Not Logged In");
	}

	/*.........................Hotel.................................*/
	@GetMapping("/hotel")
	public ResponseEntity<?> fetchAllHotels() throws RecordNotFoundException {
		if(validUser == 1) {
			return ResponseEntity.ok(hotelServiceImpl.getAllHotels());
		}else
			return ResponseEntity.ok("Not Logged In");
	}
	/*........................Room................................*/
	@GetMapping("/rooms")
	public ResponseEntity<?> viewAllRoms() {
		if(validUser == 1) {
			return ResponseEntity.ok(roomDetailsServiceImpl.showAllRoomDetails());
		}else
			return ResponseEntity.ok("Not Logged In");
	}
}


