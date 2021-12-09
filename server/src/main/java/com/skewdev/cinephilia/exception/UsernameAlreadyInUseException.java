package com.skewdev.cinephilia.exception;

public class UsernameAlreadyInUseException extends RuntimeException{
    public UsernameAlreadyInUseException(String username){
        super("Username "+username+" is already in use");
    }
}
