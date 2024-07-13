package com.erenn.todoapp.services;

import com.erenn.todoapp.DTOs.TaskCreateRequest;
import com.erenn.todoapp.entities.Task;
import com.erenn.todoapp.repos.TaskRepository;
import com.erenn.todoapp.repos.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@Service
public class TaskService {
    private final TaskRepository repository;
    private final UserRepository userRepository;

    public TaskService(TaskRepository repository, UserRepository userRepository) {
        this.repository = repository;
        this.userRepository = userRepository;
    }

    public Task getTaskById(UUID id) throws ResponseStatusException {
        return this.repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public Task createTask(TaskCreateRequest reqBody) throws ResponseStatusException {
        Task task = new Task(
                this.userRepository.findById(reqBody.user()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)),
                reqBody.text(),
                false,
                reqBody.dueDate()
        );
        this.repository.save(task);
        return task;
    }
}
