package com.cg.hbm.dto;

import java.time.LocalDate;


import lombok.Data;

@Data

public class TransactionsDTOResponseActivity {
	private int transactionId;
	private double amount;
	private LocalDate date;
	private String msg;
}

