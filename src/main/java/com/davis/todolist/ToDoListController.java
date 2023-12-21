package com.davis.todolist;

import com.davis.models.ToDoList;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/to-do-list")
public class ToDoListController {

    private final ToDoListService toDoListService;

    public ToDoListController(ToDoListService toDoListService) {this.toDoListService = toDoListService;}

    @GetMapping("{date}")
    public ResponseEntity<ToDoList> getByDate(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
        ToDoList toDoList = toDoListService.getByDate(date);
        return ResponseEntity.ok(toDoList);
    }
}
