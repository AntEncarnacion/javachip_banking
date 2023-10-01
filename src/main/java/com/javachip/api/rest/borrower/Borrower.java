package com.javachip.api.rest.borrower;

import com.javachip.api.rest.customer.Customer;
import com.javachip.api.rest.loan.Loan;
import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Borrower {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @OneToMany
    private Set<Loan> loan;
    @OneToOne
    private Customer customer;

    public Borrower() {
    }

    public Borrower(Set<Loan> newLoan, Customer newCustomer) {
        this.loan = newLoan;
        this.customer = newCustomer;
    }

    public Integer getId() {
        return this.id;
    }

    public Set<Loan> getLoan() {
        return this.loan;
    }

    public Customer getCustomer() {
        return this.customer;
    }

    public void setLoan(Set<Loan> newLoan) {
        this.loan = newLoan;
    }

    public void setCustomer(Customer newCustomer) {
        this.customer = newCustomer;
    }

    public void setId(Integer newId) {
        this.id = newId;
    }
}
