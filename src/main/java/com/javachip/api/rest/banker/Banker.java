package com.javachip.api.rest.banker;

import com.javachip.api.rest.branch.Branch;
import jakarta.persistence.*;

@Entity
public class Banker {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String firstName;
    private String lastName;
    @OneToOne
    private Branch branch;

    public Banker() {
    }

    public Banker(String newFirstName, String newLastName, Branch newBranch) {
        this.firstName = newFirstName;
        this.lastName = newLastName;
        this.branch = newBranch;
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

    public Branch getBranch() {
        return this.branch;
    }

    public void setBranch(Branch newBranch) {
        this.branch = newBranch;
    }

    public void setFirstName(String newFirstName) {
        this.firstName = newFirstName;
    }

    public void setLastName(String newLastName) {
        this.lastName = newLastName;
    }

    public void setId(Integer newId) {
        this.id = newId;
    }
}
