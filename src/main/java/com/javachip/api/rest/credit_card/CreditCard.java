package com.javachip.api.rest.credit_card;

import com.javachip.api.rest.account.Account;
import com.javachip.api.rest.customer.Customer;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class CreditCard {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @ManyToOne
    private Customer customer;
    private LocalDate expirationDate;
    @ManyToOne
    private Account account;

    public CreditCard() {
    }

    public CreditCard(Customer newCustomer, LocalDate newExpirationDate, Account newAccount) {
        this.customer = newCustomer;
        this.expirationDate = newExpirationDate;
        this.account = newAccount;
    }

    public Integer getId() {
        return this.id;
    }

    public Customer getCustomer() {
        return this.customer;
    }

    public LocalDate getExpirationDate() {
        return this.expirationDate;
    }

    public Account getAccount() {
        return this.account;
    }

    public void setCustomer(Customer newCustomer) {
        this.customer = newCustomer;
    }

    public void setExpirationDate(LocalDate newExpirationDate) {
        this.expirationDate = newExpirationDate;
    }

    public void setAccount(Account newAccount) {
        this.account = newAccount;
    }

    public void setId(Integer newId) {
        this.id = newId;
    }
}
