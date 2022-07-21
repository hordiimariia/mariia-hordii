package com.epam.spring.hw5.exception;

import com.epam.spring.hw5.model.enums.ErrorType;

import java.util.function.Supplier;

public class EntityNotFoundException extends ServiceException{

    private static final String DEFAULT_MESSAGE = "Entity is not found!";

    public EntityNotFoundException() {
        super(DEFAULT_MESSAGE);
    }

    @Override
    public ErrorType getErrorType() {
        return ErrorType.VALIDATION_ERROR_TYPE;
    }
}
