package com.pricehunt.api.exceptions;

public class NotFoundException extends RuntimeException{

    public NotFoundException() {
        super("Not Found!");
    }
}
