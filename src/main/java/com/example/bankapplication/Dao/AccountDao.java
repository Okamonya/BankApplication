package com.example.bankapplication.Dao;

import com.example.bankapplication.account.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface AccountDao extends JpaRepository<Account, Long> {

    Account findByAccountNumber(int accountNumber);
}
