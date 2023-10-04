package com.javachip.api.rest.transaction;

public class TransactionNotFoundException extends RuntimeException {
    public TransactionNotFoundException(Integer id) {
        super("Could not find transaction " + id);
    }
}
