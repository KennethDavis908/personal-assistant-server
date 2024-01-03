package com.davis.advice;

import com.davis.exceptions.AccessToDoListDeniedException;
import com.davis.exceptions.ToDoListIdNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ToDoListIdNotFoundException.class)
    public ResponseEntity<Object> handleToDoListIdNotFoundException(HttpServletRequest request, ToDoListIdNotFoundException toDoListIdNotFoundException) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("To Do List Not Found");
    }

    @ExceptionHandler(AccessToDoListDeniedException.class)
    public ResponseEntity<Object> handleAccessToDoListDeniedException(HttpServletRequest request, AccessToDoListDeniedException accessToDoListDeniedException) {
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Access To To Do List Denied");
    }
}
