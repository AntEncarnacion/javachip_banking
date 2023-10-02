package com.javachip.api.rest.loan;

public class LoanNotFoundException extends RuntimeException {
        public LoanNotFoundException(Integer id) {
            super("Could not find loan " + id);
        }
}
