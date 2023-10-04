package com.javachip.api.rest.transaction;

import org.springframework.web.bind.annotation.*;

@RestController
public class TransactionController {
    private final TransactionRepository repository;

    TransactionController(TransactionRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/transactions")
    public Iterable<Transaction> getTransactions() {
        return repository.findAll();
    }

    @GetMapping("/transaction/{id}")
    public Transaction getTransaction(@PathVariable Integer id) {
        return repository.findById(id)
            .orElseThrow(() -> new TransactionNotFoundException(id));
    }

    @PutMapping("/transaction/{id}")
    public Transaction updateTransaction(@PathVariable Integer id, @RequestBody Transaction newTransaction) {
        return repository.findById(id)
            .map(transaction -> {
                transaction.setAmount(newTransaction.getAmount());
                transaction.setAccount(newTransaction.getAccount());
                transaction.setCustomer(newTransaction.getCustomer());
                return repository.save(transaction);
            })
            .orElseGet(() -> {
                newTransaction.setId(id);
                return repository.save(newTransaction);
            });
    }

    @PostMapping("/transaction")
    public Transaction createTransaction(@RequestBody Transaction newTransaction) {
        return repository.save(newTransaction);
    }

    @DeleteMapping("/transaction/{id}")
    public void deleteTransaction(@PathVariable Integer id) {
        repository.deleteById(id);
    }
}
