package com.javachip.api.rest.loan_payment;

import org.springframework.web.bind.annotation.*;

@RestController
public class LoanPaymentController {
    private final LoanPaymentRepository repository;

    LoanPaymentController(LoanPaymentRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/loan_payments")
    public Iterable<LoanPayment> getLoanPayments() {
        return repository.findAll();
    }

    @GetMapping("/loan_payment/{id}")
    public LoanPayment getLoanPayment(@PathVariable Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new LoanPaymentNotFoundException(id));
    }

    @PutMapping("/loan_payment/{id}")
    public LoanPayment updateLoanPayment(@PathVariable Integer id, LoanPayment newLoanPayment) {
        return repository.findById(id)
                .map(loanPayment -> {
                    loanPayment.setAmount(newLoanPayment.getAmount());
                    loanPayment.setLoan(newLoanPayment.getLoan());
                    return repository.save(loanPayment);
                })
                .orElseGet(() -> {
                    newLoanPayment.setId(id);
                    return repository.save(newLoanPayment);
                });
    }

    @PostMapping("/loan_payment")
    public LoanPayment createLoanPayment(@RequestBody LoanPayment newLoanPayment) {
        return repository.save(newLoanPayment);
    }

    @DeleteMapping("/loan_payment/{id}")
    public void deleteLoanPayment(@PathVariable Integer id) {
        repository.deleteById(id);
    }
}
