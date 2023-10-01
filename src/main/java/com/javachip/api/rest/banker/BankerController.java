package com.javachip.api.rest.banker;

import org.springframework.web.bind.annotation.*;

@RestController
public class BankerController {
    private final BankerRepository bankerRepository;

    public BankerController(BankerRepository bankerRepository) {
        this.bankerRepository = bankerRepository;
    }

    @GetMapping("/bankers")
    public Iterable<Banker> getBankers() {
        return this.bankerRepository.findAll();
    }

    @GetMapping("/banker/{id}")
    public Banker getBanker(@PathVariable Integer id) {
        return this.bankerRepository.findById(id)
                .orElseThrow(() -> new BankerNotFoundException(id));
    }

    @PutMapping("/banker/{id}")
    public Banker updateBanker(Banker newBanker, @PathVariable Integer id) {
        return this.bankerRepository.findById(id)
                .map(banker -> {
                    banker.setFirstName(newBanker.getFirstName());
                    banker.setLastName(newBanker.getLastName());
                    banker.setBranch(newBanker.getBranch());
                    return this.bankerRepository.save(banker);
                })
                .orElseGet(() -> {
                    newBanker.setId(id);
                    return this.bankerRepository.save(newBanker);
                });
    }

    @PostMapping("/banker")
    public Banker createBanker(@RequestBody Banker banker) {
        return this.bankerRepository.save(banker);
    }

    @DeleteMapping("/banker/{id}")
    void deleteBanker(@PathVariable Integer id) {
        this.bankerRepository.deleteById(id);
    }
}
