package com.davis.task;

import com.davis.models.Task;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {this.taskRepository = taskRepository;}

    public Task upsert(Task task) {return taskRepository.save(task);}
}
