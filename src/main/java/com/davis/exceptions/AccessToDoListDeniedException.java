package com.davis.exceptions;

public class AccessToDoListDeniedException extends RuntimeException {
    public AccessToDoListDeniedException() { super(); }
    public AccessToDoListDeniedException(int id) {
        super("Access To To Do List By Id: " + id + " Denied");
    }
}
