package com.emirhanarici.socialmediaapp.exception;

public class UserNotFoundById extends RuntimeException{

    public UserNotFoundById(String message) {
        super(message);
    }
}
