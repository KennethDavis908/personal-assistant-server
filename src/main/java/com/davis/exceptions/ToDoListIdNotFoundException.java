package com.davis.exceptions;

public class ToDoListIdNotFoundException extends RuntimeException {
    public ToDoListIdNotFoundException() { super(); }
    public ToDoListIdNotFoundException(int id) {
        super("To Do List By Id: " + id + " Not Found");
    }
}
