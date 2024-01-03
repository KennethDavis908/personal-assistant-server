package com.davis.todolist;

import com.davis.exceptions.ToDoListIdNotFoundException;
import com.davis.models.ToDoList;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class ToDoListService {

    private final ToDoListRepository toDoListRepository;

    public ToDoListService(ToDoListRepository toDoListRepository) {this.toDoListRepository = toDoListRepository;}

    public ToDoList getByDate(LocalDate date) {
        Optional<ToDoList> toDoList = toDoListRepository.findByCreatedOnAndUserId(date, SecurityContextHolder.getContext().getAuthentication().getName());
        if(toDoList.isPresent()) return toDoList.get();
        return toDoListRepository.save(new ToDoList(date));
    }

    public ToDoList findById(int id) {
        return toDoListRepository.findById(id).orElseThrow(() -> new ToDoListIdNotFoundException(id));
    }
}
