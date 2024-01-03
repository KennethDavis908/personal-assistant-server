package com.davis.task;

import com.davis.exceptions.AccessToDoListDeniedException;
import com.davis.models.Task;
import com.davis.models.ToDoList;
import com.davis.todolist.ToDoListService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private final ToDoListService toDoListService;

    public TaskService(TaskRepository taskRepository, ToDoListService toDoListService) {
        this.taskRepository = taskRepository;
        this.toDoListService = toDoListService;
    }

    public Task upsert(Task task) {
        ToDoList toDoList = this.toDoListService.findById(task.getToDoListId());
        if(!toDoList.getUserId().equals(SecurityContextHolder.getContext().getAuthentication().getName())) throw new AccessToDoListDeniedException(task.getToDoListId());
        return taskRepository.save(task);
    }
}
