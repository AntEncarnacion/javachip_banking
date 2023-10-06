package com.javachip.api.rest.customer;

import com.javachip.api.rest.account.Account;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @OneToOne
    @JoinColumn(name = "account_id", referencedColumnName = "id", nullable = false)
    private Account account;

    @Column(name = "phone_number")
    private String phoneNumber;

    public Customer() {
    }

    public Customer(Account newAccount, String newFirstName, String newLastName, LocalDate newDateOfBirth, String newPhoneNumber) {
        this.account = newAccount;
        this.firstName = newFirstName;
        this.lastName = newLastName;
        this.dateOfBirth = newDateOfBirth;
        this.phoneNumber = newPhoneNumber;
    }

    public Integer getId() {
        return this.id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public LocalDate getDateOfBirth() {
        return this.dateOfBirth;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public Account getAccount() {
        return this.account;
    }

    public void setId(Integer newId) {
        this.id = newId;
    }

    public void setFirstName(String newFirstName) {
        this.firstName = newFirstName;
    }

    public void setLastName(String newLastName) {
        this.lastName = newLastName;
    }

    public void setDateOfBirth(LocalDate newDateOfBirth) {
        this.dateOfBirth = newDateOfBirth;
    }

    public void setPhoneNumber(String newPhoneNumber) {
        this.phoneNumber = newPhoneNumber;
    }

    public void setAccount(Account newAccount) {
        this.account = newAccount;
    }
}
