package com.erenn.todoapp.controllers;

import com.erenn.todoapp.DTOs.TaskCreateRequest;
import com.erenn.todoapp.entities.Task;
import com.erenn.todoapp.services.TaskService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService service;

    public TaskController(TaskService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable(name = "id") UUID id) throws ResponseStatusException {
        return this.service.getTaskById(id);
    }

    @PostMapping("/")
    public Task createTask(@Valid @RequestBody TaskCreateRequest request) throws ResponseStatusException {
        return this.service.createTask(request);
    }

}
