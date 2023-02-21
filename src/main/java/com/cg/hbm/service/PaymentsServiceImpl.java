package com.cg.hbm.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.cg.hbm.entity.BookingDetails;
import com.cg.hbm.entity.Payments;

import com.cg.hbm.repository.IBookingDetailsRepository;
import com.cg.hbm.repository.PaymentsRepository;
@Service
public class PaymentsServiceImpl implements PaymentsService {

	@Autowired
	private PaymentsRepository paymentsRepository;
	@Autowired
	private IBookingDetailsRepository bookingDetailsRepository;
	@Override
	public Payments addPayments(Payments payments) {
		Payments  op  = payments;
		Integer id = op.getBooking().getBookingId();
		BookingDetails bd = bookingDetailsRepository.findByBookingId(id);
		op.setBooking(bd);
		paymentsRepository.save(op);
		return op;
	}

}