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
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    private Account account;

    @Column(name = "account_id")
    private String phoneNumber;

    public Customer() {
    }

    public Customer(String newFirstName, String newLastName, LocalDate newDateOfBirth, String newPhoneNumber) {
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
}
