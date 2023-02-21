package com.cg.hbm.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionsDTO {
	private int transactionId;
	private double amount;
	private LocalDate date;
	

}
