package com.erenn.todoapp.controllers;

import com.erenn.todoapp.DTOs.UserCreateRequest;
import com.erenn.todoapp.DTOs.UserUpdatePasswordRequest;
import com.erenn.todoapp.services.UserService;
import com.erenn.todoapp.entities.User;
import jakarta.validation.Valid;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String getHelloWorld() {
        return "Hello, world";
    }

    @GetMapping("/:id")
    public User getUserById(@Param("id") UUID id) throws ResponseStatusException {
        return this.service.getUserById(id);
    }

    @GetMapping("/{usernameOrEmail}")
    public User getUserByUsernameOrEmail(@PathVariable String usernameOrEmail) throws ResponseStatusException {
        return this.service.getUserByUsernameOrEmail(usernameOrEmail);
    }

    @PostMapping("/")
    public User createUser(@Valid @RequestBody UserCreateRequest userCreateRequest) throws ResponseStatusException {
        return this.service.createUser(userCreateRequest);
    }

    @PutMapping("/{id}/update-password")
    public User updatePassword(@PathVariable UUID id, @Valid @RequestBody UserUpdatePasswordRequest userUpdatePasswordRequest) {
        return this.service.updatePassword(id, userUpdatePasswordRequest.password());
    }

    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable UUID id) {
        this.service.deleteUserById(id);
    }

}
