package com.javachip.api.rest.credit_card;

import org.springframework.web.bind.annotation.*;

@RestController
public class CreditCardController {
   private final CreditCardRepository creditCardRepository;

    public CreditCardController(CreditCardRepository creditCardRepository) {
        this.creditCardRepository = creditCardRepository;
    }

    @GetMapping("/creditCards")
    public Iterable<CreditCard> getCreditCards() {
        return this.creditCardRepository.findAll();
    }

    @GetMapping("/creditCard/{id}")
    public CreditCard getCreditCard(Integer id) {
        return this.creditCardRepository.findById(id)
                .orElseThrow(() -> new CreditCardNotFoundException(id));
    }

    @PutMapping("/creditCard/{id}")
    public CreditCard updateCreditCard(CreditCard newCreditCard, @PathVariable Integer id) {
        return this.creditCardRepository.findById(id)
                .map(creditCard -> {
                    creditCard.setCustomer(newCreditCard.getCustomer());
                    creditCard.setExpirationDate(newCreditCard.getExpirationDate());
                    creditCard.setAccount(newCreditCard.getAccount());
                    return this.creditCardRepository.save(creditCard);
                })
                .orElseGet(() -> {
                    newCreditCard.setId(id);
                    return this.creditCardRepository.save(newCreditCard);
                });
    }

    @PostMapping("/creditCard")
    public CreditCard createCreditCard(@RequestBody CreditCard creditCard) {
        return this.creditCardRepository.save(creditCard);
    }

    @DeleteMapping("/creditCard/{id}")
    void deleteCreditCard(@PathVariable Integer id) {
        this.creditCardRepository.deleteById(id);
    }
}
