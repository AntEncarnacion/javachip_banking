package com.javachip.api.rest.transaction;

import com.javachip.api.rest.account.Account;
import com.javachip.api.rest.customer.Customer;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.math.BigDecimal;

public class Transaction {
    @Id
    @GeneratedValue
    private Integer id;
    private Account account;
    private Customer customer;
    private BigDecimal amount;

    public Transaction() {
    }

    public Transaction(Account newAccount, Customer newCustomer, BigDecimal newAmount) {
        this.account = newAccount;
        this.customer = newCustomer;
        this.amount = newAmount;
    }

    public Integer getId() {
        return this.id;
    }

    public Account getAccount() {
        return this.account;
    }

    public Customer getCustomer() {
        return this.customer;
    }

    public BigDecimal getAmount() {
        return this.amount;
    }

    public void setAccount(Account newAccount) {
        this.account = newAccount;
    }

    public void setCustomer(Customer newCustomer) {
        this.customer = newCustomer;
    }

    public void setAmount(BigDecimal newAmount) {
        this.amount = newAmount;
    }

    public void setId(Integer newId) {
        this.id = newId;
    }
}
