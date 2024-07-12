package com.erenn.todoapp.User;

import com.erenn.todoapp.User.DTOs.UserCreateDTO;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UserService {
    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User getUserById(Long id) throws ResponseStatusException{
        return this.repository.findById(id).orElseThrow(() -> new ResponseStatusException((HttpStatus.NOT_FOUND)));
    }

    public User getUserByUsernameOrEmail(String usernameOrEmail) throws ResponseStatusException {
        return this.repository.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail).orElseThrow(() -> new ResponseStatusException((HttpStatus.NOT_FOUND)));
    }

    public User createUser(UserCreateDTO userCreateData) throws ResponseStatusException {
        if (this.repository.findByUsernameOrEmail(userCreateData.username(), userCreateData.email()).isEmpty()) {
            User user = new User(userCreateData.username(), userCreateData.email(), userCreateData.password());
            this.repository.save(user);
            return user;
        }
        throw new ResponseStatusException(HttpStatus.CONFLICT);
    }

    public User updateUsername(Long id, String username) throws ResponseStatusException {
        if (this.repository.findByUsername(username).isEmpty()) {
            this.repository.updateUsernameByID(id, username);
            return this.repository.findById(id).orElseThrow(() -> new ResponseStatusException((HttpStatus.NOT_FOUND)));
        }
        throw new ResponseStatusException(HttpStatus.CONFLICT);
    }

    public User updatePassword(Long id, String newPassword) throws ResponseStatusException {
        User user = this.repository.findById(id).orElseThrow(() -> new ResponseStatusException((HttpStatus.NOT_FOUND)));
        if (user.getPassword().equals(newPassword)) {
            throw new ResponseStatusException(HttpStatus.CONFLICT);
        }
        this.repository.updatePasswordByID(id, newPassword);
        user.setPassword(newPassword);
        return user;
    }

    public void deleteUserById(Long id) {
        this.repository.deleteById(id);
    }

}
