package com.javachip.api.rest.customer;

public class CustomerNotFoundException extends RuntimeException {
    public CustomerNotFoundException(Integer id) {
        super("Could not find customer " + id);
    }
}
