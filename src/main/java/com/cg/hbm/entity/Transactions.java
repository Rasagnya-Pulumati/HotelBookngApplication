package com.cg.hbm.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Entity
@NoArgsConstructor
@Table

public class Transactions {
	    @Id
	    @GeneratedValue(strategy =GenerationType.AUTO )
		private int transactionId;
		private double amount;
		private LocalDate date;
		public Transactions(double amount, LocalDate date) {
			super();
			this.amount = amount;
			this.date = date;
		}
		public void setTransactionId(Object object) {
			// TODO Auto-generated method stub
			
		}
		

}

