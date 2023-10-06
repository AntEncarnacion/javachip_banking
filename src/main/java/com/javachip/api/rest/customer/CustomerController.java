package com.javachip.api.rest.customer;

import com.javachip.api.rest.account.Account;
import com.javachip.api.rest.account.AccountNotFoundException;
import com.javachip.api.rest.account.AccountRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class CustomerController {
    private final CustomerRepository customerRepository;
    private final AccountRepository accountRepository;

    public CustomerController(CustomerRepository customerRepository, AccountRepository accountRepository) {
        this.customerRepository = customerRepository;
        this.accountRepository = accountRepository;
    }

    @GetMapping("/customers")
    public Iterable<Customer> getCustomers() {
        return this.customerRepository.findAll();
    }

    @GetMapping("/customer/{id}")
    public Customer getCustomer(@PathVariable Integer id) {
        return this.customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException(id));
    }

    @PostMapping("/customer")
    public Customer createCustomer(@RequestBody CustomerCreationDTO customerDTO) {
        Customer customer = new Customer();
        customer.setFirstName(customerDTO.getFirstName());
        customer.setLastName(customerDTO.getLastName());
        customer.setDateOfBirth(customerDTO.getDateOfBirth());
        customer.setPhoneNumber(customerDTO.getPhoneNumber());
        Optional<Account> account;
        account = this.accountRepository.findById(customerDTO.getAccountId());
        account.ifPresent(customer::setAccount);
        account.ifPresentOrElse(
                customer::setAccount,
                () -> {
                    throw new AccountNotFoundException(customerDTO.getAccountId());
                }
        );
        return this.customerRepository.save(customer);
    }

    @PutMapping("/customer/{id}")
    public Customer updateCustomer(@RequestBody Customer newCustomer, @PathVariable Integer id) {
        return this.customerRepository.findById(id)
                .map(customer -> {
                    customer.setFirstName(newCustomer.getFirstName());
                    customer.setLastName(newCustomer.getLastName());
                    customer.setDateOfBirth(newCustomer.getDateOfBirth());
                    return this.customerRepository.save(customer);
                })
                .orElseGet(() -> {
                    newCustomer.setId(id);
                    return this.customerRepository.save(newCustomer);
                });
    }

    @DeleteMapping("/customer/{id}")
    void deleteCustomer(@PathVariable Integer id) {
        this.customerRepository.deleteById(id);
    }
}
