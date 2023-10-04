package com.javachip.api.rest.loan_payment;

public class LoanPaymentNotFoundException extends RuntimeException {
        public LoanPaymentNotFoundException(Integer id) {
            super("Could not find loan payment " + id);
        }
}
