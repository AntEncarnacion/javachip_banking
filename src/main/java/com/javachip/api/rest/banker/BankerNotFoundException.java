package com.javachip.api.rest.banker;

public class BankerNotFoundException extends RuntimeException {
    BankerNotFoundException(Integer id) {
        super("Could not find banker " + id);
    }
}
