package com.example.bankapplication.Service.Account;

import com.example.bankapplication.Repository.CustomerRepository;
import com.example.bankapplication.Service.CustomerService;
import com.example.bankapplication.account.Transaction;
import com.example.bankapplication.main.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionServices{

    @Autowired
    private CustomerRepository customerRepository;


    @Override
    public List<Transaction> findTransactionList(String kra) {
        Customer customer = customerRepository.findByKra(kra);
        List<Transaction> transactionList = customer.getAccount().getTransactionList();


        return transactionList;
    }
}
