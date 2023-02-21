package com.cg.hbm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.hbm.entity.Transactions;
import com.cg.hbm.exception.InvalidInputDataException;

@Repository
public interface TransactionsRepository  extends JpaRepository<Transactions, Integer> {
//	Transactions addTransactions(Transactions transactions);
	List<Transactions> getTransactionsByTransactionId(int transactionId)throws InvalidInputDataException;

	
} 