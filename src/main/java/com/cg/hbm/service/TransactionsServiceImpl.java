package com.cg.hbm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.hbm.entity.Transactions;
import com.cg.hbm.exception.InvalidInputDataException;
import com.cg.hbm.repository.TransactionsRepository;

@Service

public class TransactionsServiceImpl implements TransactionsService {
	@Autowired
	private TransactionsRepository transactionsrepository;

	@Override
	public Transactions addTransactions(Transactions transactions) {

//	    	 Transactions t=transactionsrepository.save(transactions);

		return transactionsrepository.save(transactions);

	}

	@Override
	public List<Transactions> getAllTransactions() {

		return transactionsrepository.findAll();

	}

	@Override

	public List<Transactions> getTransactionsByTransactionId(int transactionId) throws InvalidInputDataException {

		if (transactionsrepository.existsById(transactionId)) {

			return transactionsrepository.getTransactionsByTransactionId(transactionId);

		}

		else {

			throw new InvalidInputDataException("No review exists with this key = " + transactionId);

		}

	}

}
