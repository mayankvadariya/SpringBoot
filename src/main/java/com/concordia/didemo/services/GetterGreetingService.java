package com.concordia.didemo.services;

import org.springframework.stereotype.Service;

/**
 * Created by jt on 5/24/17.
 */

//This provides an implementation of the GreetingService
@Service
public class GetterGreetingService implements GreetingService {

    @Override
    public String sayGreeting() {
        return "Hello - I was injected by the getter";
    }
}
