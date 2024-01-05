package com.davis.exceptions;

public class AccessToNoteDeniedException extends RuntimeException {
    public AccessToNoteDeniedException() { super(); }
    public AccessToNoteDeniedException(int id) {
        super("Access To To Do List By Id: " + id + " Denied");
    }
}
