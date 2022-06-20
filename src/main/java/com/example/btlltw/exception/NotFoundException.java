package com.example.btlltw.exception;

public class NotFoundException extends ServiceException{
    public NotFoundException() {
        super(MessageError.NOT_FOUND, null, null);
    }
}
