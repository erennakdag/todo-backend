package com.erenn.todoapp.TodoList;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoListRepository extends JpaRepository<TodoListElement, Long> {
}
