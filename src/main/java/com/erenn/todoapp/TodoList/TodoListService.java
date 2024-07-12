package com.erenn.todoapp.TodoList;

import org.springframework.stereotype.Service;

@Service
public class TodoListService {
    private TodoListRepository repository;

    public TodoListService(TodoListRepository repository) {
        this.repository = repository;
    }
}
