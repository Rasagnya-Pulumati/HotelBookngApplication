package com.cg.hbm.util;

import org.springframework.stereotype.Component;

import com.cg.hbm.dto.TransactionsDTO;
import com.cg.hbm.dto.TransactionsDTOResponseActivity;
import com.cg.hbm.entity.Transactions;
@Component
public class TransactionsDTOConvertor 
{
	public TransactionsDTOResponseActivity getTransactionsDTOResponseActivity(Transactions transactions)
	{
		TransactionsDTOResponseActivity dto=new TransactionsDTOResponseActivity();
		dto.setTransactionId(transactions.getTransactionId());
		dto.setAmount(transactions.getAmount());
		dto.setDate(transactions.getDate());
		dto.setMsg("Transactions saved");
		return dto;
	}

        public TransactionsDTO getTransactionsDTO(Transactions t)
        {
        	TransactionsDTO obj=new TransactionsDTO(t.getTransactionId(),t.getAmount(),t.getDate());
        	return obj;
        }
}