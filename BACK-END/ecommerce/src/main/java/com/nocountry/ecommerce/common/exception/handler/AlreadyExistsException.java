package com.nocountry.ecommerce.common.exception.handler;

public class AlreadyExistsException extends RuntimeException{
    public AlreadyExistsException(String message) {
        super(message);
    }
}
