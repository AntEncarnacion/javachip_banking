package com.javachip.api.rest.branch;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Branch {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private Integer assets;
    private String address;

    public Branch() {
    }

    public Branch(String newName, Integer newAssets, String newAddress) {
        this.name = newName;
        this.assets = newAssets;
        this.address = newAddress;
    }

    public Integer getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public Integer getAssets() {
        return this.assets;
    }

    public String getAddress() {
        return this.address;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public void setAssets(Integer newAssets) {
        this.assets = newAssets;
    }

    public void setAddress(String newAddress) {
        this.address = newAddress;
    }

    public void setId(Integer newId) {
        this.id = newId;
    }
}
