package com.javachip.api.rest.loan;

import org.springframework.web.bind.annotation.*;

@RestController
public class LoanController {
    private final LoanRepository repository;

    LoanController(LoanRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/loans")
    public Iterable<Loan> getLoans() {
        return repository.findAll();
    }

    @GetMapping("/loan/{id}")
    public Loan getLoan(Integer id) {
        return repository.findById(id)
            .orElseThrow(() -> new LoanNotFoundException(id));
    }

    @PutMapping("/loan/{id}")
    public Loan updateLoan(Integer id, Loan newLoan) {
        return repository.findById(id)
            .map(loan -> {
                loan.setAmount(newLoan.getAmount());
                loan.setRemainingAmount(newLoan.getRemainingAmount());
                loan.setInterestRate(newLoan.getInterestRate());
                loan.setTerm(newLoan.getTerm());
                return repository.save(loan);
            })
            .orElseGet(() -> {
                newLoan.setId(id);
                return repository.save(newLoan);
            });
    }

    @PostMapping("/loan")
    public Loan createLoan(Loan newLoan) {
        return repository.save(newLoan);
    }

    @DeleteMapping("/loan/{id}")
    public void deleteLoan(Integer id) {
        repository.deleteById(id);
    }
}
