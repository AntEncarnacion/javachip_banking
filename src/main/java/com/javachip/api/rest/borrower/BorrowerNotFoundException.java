package com.javachip.api.rest.borrower;

public class BorrowerNotFoundException extends RuntimeException {
    BorrowerNotFoundException(Integer id) {
        super("Could not find borrower " + id);
    }
}
