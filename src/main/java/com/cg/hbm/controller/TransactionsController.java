package com.cg.hbm.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.hbm.dto.TransactionsDTO;
import com.cg.hbm.dto.TransactionsDTOResponseActivity;
import com.cg.hbm.entity.Transactions;
import com.cg.hbm.exception.InvalidInputDataException;
import com.cg.hbm.service.TransactionsService;
import com.cg.hbm.util.TransactionsDTOConvertor;

@RestController
@RequestMapping("/transactions")

public class TransactionsController {
	@Autowired
	TransactionsService transactionsService;
	@Autowired
	TransactionsDTOConvertor transactionsDTOConvertor;

	@PostMapping("/add")
	public ResponseEntity<Transactions> addTransactions(@RequestBody Transactions transactions)
			throws InvalidInputDataException {

		Transactions newTransactions = transactionsService.addTransactions(transactions);
		TransactionsDTOResponseActivity responseDTO = transactionsDTOConvertor
				.getTransactionsDTOResponseActivity(newTransactions);
		return new ResponseEntity<Transactions>(newTransactions, HttpStatus.OK);
	}

	@GetMapping("/allTransactions")
	public ResponseEntity<List<TransactionsDTO>> getAllTransactions() throws InvalidInputDataException {

		List<Transactions> allTransactions = transactionsService.getAllTransactions(); // give us raw data (complete
																						// information , which we cannot
																						// share with users directly)
		// Converting into DTO form , which we can share with user
		List<TransactionsDTO> allTransactionsDTO = new ArrayList<>();

		for (Transactions transactions : allTransactions) {

			allTransactionsDTO.add(transactionsDTOConvertor.getTransactionsDTO(transactions));

		}

		return new ResponseEntity<List<TransactionsDTO>>(allTransactionsDTO, HttpStatus.OK);

	}

	@GetMapping("/{transactionId}")

	public ResponseEntity<List<TransactionsDTO>> getTransactionByTransactionId(@PathVariable int transactionId)
			throws InvalidInputDataException {

		List<Transactions> allTransactions = transactionsService.getTransactionsByTransactionId(transactionId);

		if (allTransactions.isEmpty())

		{

			throw new InvalidInputDataException("no transactions exists with this key" + transactionId);
		}

		else {

			List<TransactionsDTO> allTransactionDTO = new ArrayList<>();

			for (Transactions transactions : allTransactions) {

				allTransactionDTO.add(transactionsDTOConvertor.getTransactionsDTO(transactions));

			}

			return new ResponseEntity<List<TransactionsDTO>>(allTransactionDTO, HttpStatus.OK);

		}

	}
}
