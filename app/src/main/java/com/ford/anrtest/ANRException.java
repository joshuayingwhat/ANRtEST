package com.ford.anrtest;

public class ANRException extends RuntimeException{

    public ANRException(String message) {

        throw new RuntimeException(message);
    }
}
