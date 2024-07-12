package com.erenn.todoapp.User.DTOs;

import jakarta.validation.constraints.NotNull;

public record UserUpdatePasswordDTO(
        @NotNull String password
) {
}
