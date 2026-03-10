package com.example.scheduler;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tasks")
@CrossOrigin(origins = "http://localhost:4200")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping("/trigger")
    public void triggerTask() {
        taskService.triggerManualTask();
    }

    @GetMapping("/status")
    public TaskStatus getStatus() {
        return taskService.getStatus();
    }
}