package com.javachip.api.rest.branch;

public class BranchNotFoundException extends RuntimeException {
    BranchNotFoundException(Integer id) {
        super("Could not find branch " + id);
    }
}
