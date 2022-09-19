package org.example.exception;

public class NumberException extends RuntimeException {

    public NumberException() {
        super("String for BALLOON can't contain number!");
    }
}
