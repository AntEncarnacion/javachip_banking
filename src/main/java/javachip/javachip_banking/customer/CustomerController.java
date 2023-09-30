package javachip.javachip_banking.customer;

import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerController {
   private final CustomerRepository customerRepository;

   public CustomerController(CustomerRepository customerRepository) {
      this.customerRepository = customerRepository;
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
   public Customer createCustomer(@RequestBody Customer customer) {
      return this.customerRepository.save(customer);
   }

   @PutMapping("/customer/{id}")
    public Customer updateCustomer(Customer newCustomer, @PathVariable Integer id) {
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
