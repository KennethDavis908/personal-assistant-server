package com.davis.task;

import com.davis.models.Task;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/task")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {this.taskService = taskService;}

    @PutMapping
    public ResponseEntity<Task> upsetTask(@RequestBody Task task) {
        Task upsertedTask = taskService.upsert(task);

        HttpStatus status;
        if (task.getId() == upsertedTask.getId()) status = HttpStatus.OK;
        else status = HttpStatus.CREATED;

        return ResponseEntity.status(status).body(upsertedTask);
    }
}
