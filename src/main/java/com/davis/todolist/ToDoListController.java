package com.davis.todolist;

import com.davis.models.ToDoList;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/to-do-list")
public class ToDoListController {

    private final ToDoListService toDoListService;

    public ToDoListController(ToDoListService toDoListService) {this.toDoListService = toDoListService;}

    @GetMapping("{date}")
    public ResponseEntity<ToDoList> getByDate(@PathVariable("date") LocalDate date) {
        ToDoList toDoList = toDoListService.getByDate(date);
        return ResponseEntity.ok(toDoList);
    }
}
