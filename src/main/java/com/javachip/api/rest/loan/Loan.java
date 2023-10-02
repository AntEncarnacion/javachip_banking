package com.javachip.api.rest.loan;

import com.javachip.api.rest.account.Account;
import com.javachip.api.rest.branch.Branch;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private BigDecimal amount;
    private BigDecimal remainingAmount;
    private BigDecimal interestRate;
    @OneToOne
    private Branch branch;
    @ManyToOne
    private Account account;
    private Integer term;

    public Loan() {
    }

    public Loan(BigDecimal newAmount, BigDecimal newRemainingAmount, BigDecimal newInterestRate, Branch newBranch, Account newAccount, Integer newTerm) {
        this.amount = newAmount;
        this.remainingAmount = newRemainingAmount;
        this.interestRate = newInterestRate;
        this.branch = newBranch;
        this.account = newAccount;
        this.term = newTerm;
    }

    public Integer getId() {
        return this.id;
    }

    public BigDecimal getAmount() {
        return this.amount;
    }

    public BigDecimal getRemainingAmount() {
        return this.remainingAmount;
    }

    public BigDecimal getInterestRate() {
        return this.interestRate;
    }

    public Branch getBranch() {
        return this.branch;
    }

    public Account getAccount() {
        return this.account;
    }

    public Integer getTerm() {
        return this.term;
    }

    public void setAmount(BigDecimal newAmount) {
        this.amount = newAmount;
    }

    public void setRemainingAmount(BigDecimal newRemainingAmount) {
        this.remainingAmount = newRemainingAmount;
    }

    public void setInterestRate(BigDecimal newInterestRate) {
        this.interestRate = newInterestRate;
    }

    public void setBranch(Branch newBranch) {
        this.branch = newBranch;
    }

    public void setAccount(Account newAccount) {
        this.account = newAccount;
    }

    public void setTerm(Integer newTerm) {
        this.term = newTerm;
    }

    public void setId(Integer newId) {
        this.id = newId;
    }
}
