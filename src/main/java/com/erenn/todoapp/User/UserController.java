package com.erenn.todoapp.User;

import com.erenn.todoapp.User.DTOs.UserCreateDTO;
import com.erenn.todoapp.User.DTOs.UserUpdatePasswordDTO;
import com.erenn.todoapp.User.DTOs.UserUpdateUsernameDTO;
import jakarta.validation.Valid;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

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
    public User getUserById(@Param("id") Long id) throws ResponseStatusException {
        return this.service.getUserById(id);
    }

    @GetMapping("/{usernameOrEmail}")
    public User getUserByUsernameOrEmail(@PathVariable String usernameOrEmail) throws ResponseStatusException {
        return this.service.getUserByUsernameOrEmail(usernameOrEmail);
    }

    @PostMapping("/")
    public User createUser(@Valid @RequestBody UserCreateDTO userCreateDTO) throws ResponseStatusException {
        return this.service.createUser(userCreateDTO);
    }

    @PutMapping("/{id}/update-username")
    public User updateUsername(@PathVariable Long id, @Valid @RequestBody UserUpdateUsernameDTO userUpdateUsernameDTO) {
        return this.service.updateUsername(id, userUpdateUsernameDTO.username());
    }

    @PutMapping("/{id}/update-password")
    public User updatePassword(@PathVariable Long id, @Valid @RequestBody UserUpdatePasswordDTO userUpdatePasswordDTO) {
        return this.service.updatePassword(id, userUpdatePasswordDTO.password());
    }

    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable Long id) {
        this.service.deleteUserById(id);
    }

}
