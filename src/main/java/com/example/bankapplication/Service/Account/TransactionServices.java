package com.example.bankapplication.Service.Account;

import com.example.bankapplication.account.Transaction;

import java.util.List;

public interface TransactionServices {
    List<Transaction> findTransactionList(String username);
}
