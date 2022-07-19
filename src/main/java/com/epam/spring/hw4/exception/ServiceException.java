package com.epam.spring.hw4.exception;

import com.epam.spring.hw4.model.enums.ErrorType;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public abstract class ServiceException extends RuntimeException{
    private ErrorType errorType;

    public ServiceException(String message) {
        super(message);
    }

    public ErrorType getErrorType(){
        return ErrorType.FATAL_ERROR_TYPE;
    }
}
