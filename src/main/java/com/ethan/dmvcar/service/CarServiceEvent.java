package com.ethan.dmvcar.service;

import org.springframework.context.ApplicationEvent;

/**
 * This is an optional class used in publishing application events.
 * This can be used to inject events into the Spring Boot audit management endpoint.
 */
public class CarServiceEvent extends ApplicationEvent {

    public CarServiceEvent(Object source) {
        super(source);
    }

    public String toString() {
        return "My Car Service Event";
    }
}
