package com.cg.hbm.service;

import com.cg.hbm.entity.Transactions;
import com.cg.hbm.exception.InvalidInputDataException;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface TransactionsService {

	Transactions addTransactions(Transactions transactions);
	List<Transactions> getAllTransactions();
	
	List<Transactions> getTransactionsByTransactionId(int transactionId) throws InvalidInputDataException;
	

}


