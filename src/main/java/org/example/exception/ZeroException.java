package org.example.exception;

public class ZeroException extends Exception {

    public ZeroException() {
        super("Can't work with zero!");
    }
}
