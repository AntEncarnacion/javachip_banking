package com.javachip.api.rest.credit_card;

public class CreditCardNotFoundException extends RuntimeException {
    CreditCardNotFoundException(Integer id) {
        super("Could not find credit card " + id);
    }
}
