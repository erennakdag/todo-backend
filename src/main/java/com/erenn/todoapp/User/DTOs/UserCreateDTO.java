package com.erenn.todoapp.User.DTOs;

import jakarta.validation.constraints.NotNull;

public record UserCreateDTO(
        @NotNull String username,
        @NotNull String email,
        @NotNull String password
) {
}
