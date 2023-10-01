package com.javachip.api.rest.loan_payment;

import com.javachip.api.rest.loan.Loan;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
public class LoanPayment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @ManyToOne
    private Loan loan;
    private BigDecimal amount;

    public LoanPayment() {
    }

    public LoanPayment(Loan newLoan, BigDecimal newAmount) {
        this.loan = newLoan;
        this.amount = newAmount;
    }

    public Integer getId() {
        return this.id;
    }

    public Loan getLoan() {
        return this.loan;
    }

    public BigDecimal getAmount() {
        return this.amount;
    }

    public void setLoan(Loan newLoan) {
        this.loan = newLoan;
    }

    public void setAmount(BigDecimal newAmount) {
        this.amount = newAmount;
    }

    public void setId(Integer newId) {
        this.id = newId;
    }
}
