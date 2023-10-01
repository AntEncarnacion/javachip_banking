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
    private BigDecimal remaningAmount;
    private BigDecimal interestRate;
    @OneToOne
    private Branch branch;
    @ManyToOne
    private Account account;
    private Integer loanTerm;

    public Loan() {
    }

    public Loan(BigDecimal newAmount, BigDecimal newRemaningAmount, BigDecimal newInterestRate, Branch newBranch, Account newAccount, Integer newLoanTerm) {
        this.amount = newAmount;
        this.remaningAmount = newRemaningAmount;
        this.interestRate = newInterestRate;
        this.branch = newBranch;
        this.account = newAccount;
        this.loanTerm = newLoanTerm;
    }

    public Integer getId() {
        return this.id;
    }

    public BigDecimal getAmount() {
        return this.amount;
    }

    public BigDecimal getRemaningAmount() {
        return this.remaningAmount;
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

    public Integer getLoanTerm() {
        return this.loanTerm;
    }

    public void setAmount(BigDecimal newAmount) {
        this.amount = newAmount;
    }

    public void setRemaningAmount(BigDecimal newRemaningAmount) {
        this.remaningAmount = newRemaningAmount;
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

    public void setLoanTerm(Integer newLoanTerm) {
        this.loanTerm = newLoanTerm;
    }

    public void setId(Integer newId) {
        this.id = newId;
    }
}
