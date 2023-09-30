package com.javachip.api.rest.account;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

@Entity
@Table(name = "accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String type;

    private BigDecimal balance;

    @Column(name = "date_opened")
    private LocalDate dateOpened;

//    private Branch branch;

    public Account() {
    }

    public Account(String newType, Double newBalance) {
        this.type = newType;
        this.balance = new BigDecimal(newBalance).setScale(2, RoundingMode.HALF_UP);
        this.dateOpened = LocalDate.now();
    }

    public Integer getId() {
        return this.id;
    }

    public String getType() {
        return this.type;
    }

    public BigDecimal getBalance() {
        return this.balance;
    }

    public LocalDate getDateOpened() {
        return this.dateOpened;
    }

    public void setType(String newType) {
        this.type = newType;
    }

    public void setBalance(Double newBalance) {
        this.balance = new BigDecimal(newBalance).setScale(2, RoundingMode.HALF_UP);;
    }

    public void setDateOpened(LocalDate newDateOpened) {
        this.dateOpened = newDateOpened;
    }

    public void setId(Integer newId) {
        this.id = newId;
    }
}
