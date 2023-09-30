package javachip.javachip_banking.customer;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private Integer accountId;
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

    public Integer getAccountId() {
        return this.accountId;
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

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }
}
