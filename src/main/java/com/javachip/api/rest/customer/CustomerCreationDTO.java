package com.javachip.api.rest.customer;

import org.springframework.cglib.core.Local;

import java.time.LocalDate;

public class CustomerCreationDTO {
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String phoneNumber;
    private Integer accountId;

    public CustomerCreationDTO() {
    }

    public CustomerCreationDTO(String newFirstName, String newLastName, LocalDate newDateOfBirth, String newPhoneNumber, Integer newAccountId) {
        this.firstName = newFirstName;
        this.lastName = newLastName;
        this.dateOfBirth = newDateOfBirth;
        this.phoneNumber = newPhoneNumber;
        this.accountId = newAccountId;
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

    public Integer getAccountId() {
        return this.accountId;
    }
}
