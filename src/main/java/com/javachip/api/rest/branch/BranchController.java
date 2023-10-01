package com.javachip.api.rest.branch;

import org.springframework.web.bind.annotation.*;

@RestController
public class BranchController {
    private final BranchRepository repository;

    public BranchController(BranchRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/branches")
    public Iterable<Branch> getBranches() {
        return this.repository.findAll();
    }

    @GetMapping("/branch/{id}")
    public Branch getBranch(Integer id) {
        return this.repository.findById(id)
                .orElseThrow(() -> new BranchNotFoundException(id));
    }

    @PutMapping("/branch/{id}")
    public Branch updateBranch(Branch newBranch, @PathVariable Integer id) {
        return this.repository.findById(id)
                .map(branch -> {
                    branch.setAddress(newBranch.getAddress());
                    branch.setName(newBranch.getName());
                    branch.setAssets(newBranch.getAssets());
                    return this.repository.save(branch);
                })
                .orElseGet(() -> {
                    newBranch.setId(id);
                    return this.repository.save(newBranch);
                });
    }

    @PostMapping("/branch")
    public Branch createBranch(@RequestBody Branch branch) {
        return this.repository.save(branch);
    }

    @DeleteMapping("/branch/{id}")
    void deleteBranch(@PathVariable Integer id) {
        this.repository.deleteById(id);
    }
}
