package com.davis.todolist;

import com.davis.models.ToDoList;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/to-do-list")
public class ToDoListController {

    private final ToDoListService toDoListService;

    public ToDoListController(ToDoListService toDoListService) {this.toDoListService = toDoListService;}

    @GetMapping("{date}")
    public ResponseEntity<ToDoList> findByDate(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
        ToDoList toDoList = toDoListService.findByDate(date);
        return ResponseEntity.ok(toDoList);
    }
}
