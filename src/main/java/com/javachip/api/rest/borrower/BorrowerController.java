package com.javachip.api.rest.borrower;

import org.springframework.web.bind.annotation.*;

@RestController
public class BorrowerController {
    private final BorrowerRepository borrowerRepository;

    public BorrowerController(BorrowerRepository borrowerRepository) {
        this.borrowerRepository = borrowerRepository;
    }

    @GetMapping("/borrowers")
    public Iterable<Borrower> getBorrowers() {
        return this.borrowerRepository.findAll();
    }

    @GetMapping("/borrower/{id}")
    public Borrower getBorrower(Integer id) {
        return this.borrowerRepository.findById(id)
                .orElseThrow(() -> new BorrowerNotFoundException(id));
    }

    @PutMapping("/borrower/{id}")
    public Borrower updateBorrower(Borrower newBorrower, @PathVariable Integer id) {
        return this.borrowerRepository.findById(id)
                .map(borrower -> {
                    borrower.setLoan(newBorrower.getLoan());
                    borrower.setCustomer(newBorrower.getCustomer());
                    return this.borrowerRepository.save(borrower);
                })
                .orElseGet(() -> {
                    newBorrower.setId(id);
                    return this.borrowerRepository.save(newBorrower);
                });
    }

    @PostMapping("/borrower")
    public Borrower createBorrower(@RequestBody Borrower borrower) {
        return this.borrowerRepository.save(borrower);
    }

    @DeleteMapping("/borrower/{id}")
    void deleteBorrower(@PathVariable Integer id) {
        this.borrowerRepository.deleteById(id);
    }
}
