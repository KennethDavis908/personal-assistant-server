package com.davis.todolist;

import com.davis.models.ToDoList;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class ToDoListService {

    private final ToDoListRepository toDoListRepository;

    public ToDoListService(ToDoListRepository toDoListRepository) {this.toDoListRepository = toDoListRepository;}

    public ToDoList getByDate(LocalDate date) {
        Optional<ToDoList> toDoList = toDoListRepository.findByCreatedOn(date);
        if(toDoList.isPresent()) return toDoList.get();
        return toDoListRepository.save(new ToDoList(date));
    }
}
