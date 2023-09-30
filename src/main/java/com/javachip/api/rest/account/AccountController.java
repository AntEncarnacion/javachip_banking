package com.javachip.api.rest.account;

import org.springframework.web.bind.annotation.*;

@RestController
public class AccountController {
    private final AccountRepository accountRepository;

    public AccountController(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @GetMapping("/accounts")
    public Iterable<Account> getAccount() {
        return this.accountRepository.findAll();
    }

    @GetMapping("/account/{id}")
    public Account getAccount(@PathVariable Integer id) {
        return this.accountRepository.findById(id)
                .orElseThrow(() -> new AccountNotFoundException(id));
    }

    @PostMapping("/account")
    public Account createAccount(@RequestBody Account account) {
        return this.accountRepository.save(account);
    }

    @PutMapping("/account/{id}")
    public Account updateAccount(Account newAccount, @PathVariable Integer id) {
        return this.accountRepository.findById(id)
                .map(account -> {
                    account.setType(newAccount.getType());
                    account.setBalance(newAccount.getBalance().doubleValue());
                    return this.accountRepository.save(account);
                })
                .orElseGet(() -> {
                    newAccount.setId(id);
                    return this.accountRepository.save(newAccount);
                });
    }

    @DeleteMapping("/account/{id}")
    void deleteAccount(@PathVariable Integer id) {
        this.accountRepository.deleteById(id);
    }
}
