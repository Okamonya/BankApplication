package com.example.bankapplication.Dao;

import com.example.bankapplication.account.Transaction;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TransactionDao extends CrudRepository<Transaction, Long> {

    List<Transaction> findAll();
}
