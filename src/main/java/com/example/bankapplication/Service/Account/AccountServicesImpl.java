package com.example.bankapplication.Service.Account;

import com.example.bankapplication.Dao.AccountDao;
import com.example.bankapplication.Repository.AccountRepo;
import com.example.bankapplication.account.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class AccountServicesImpl implements AccountRepo {

    private static int nextAccountNumber = 112233445;

    @Autowired
    private AccountDao accountDao;




    @Override
    public Account createAccount() {
        Account account = new Account();
        account.setBalance(new BigDecimal(2.2));
        account.setAccountNumber(accountGen());

        accountDao.save(account);

        return accountDao.findByAccountNumber(account.getAccountNumber());
    }

    private int accountGen() {
        return ++nextAccountNumber;
    }
}
