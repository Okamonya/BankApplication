package com.example.bankapplication.Dao;

import com.example.bankapplication.account.Account;
import org.springframework.data.repository.CrudRepository;

public interface AccountDao extends CrudRepository<Account, Long> {

    Account findByAccountNumber(int accountNumber);
}
