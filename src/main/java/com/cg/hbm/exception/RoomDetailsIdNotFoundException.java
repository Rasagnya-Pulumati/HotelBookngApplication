package com.cg.hbm.exception;

public class RoomDetailsIdNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public RoomDetailsIdNotFoundException(String message) {
		super(message);
	}

}