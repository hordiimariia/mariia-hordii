package com.epam.spring.homework3.service.exception;

public class DistanceNotFoundException extends RuntimeException {
    public DistanceNotFoundException(String message) {
        super(message);
    }
}
