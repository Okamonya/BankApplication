package com.example.bankapplication.account;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date date;
    private double amount;
    private BigDecimal availableBalance;


    @ManyToOne
    @JoinColumn( name = "account_id")
    private Account account;

    public Transaction(){

    }

    public Transaction(Date date, double amount, BigDecimal availableBalance, Account account) {
        this.date = date;
        this.amount = amount;
        this.availableBalance = availableBalance;
        this.account = account;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public BigDecimal getAvailableBalance() {
        return availableBalance;
    }

    public void setAvailableBalance(BigDecimal availableBalance) {
        this.availableBalance = availableBalance;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}

