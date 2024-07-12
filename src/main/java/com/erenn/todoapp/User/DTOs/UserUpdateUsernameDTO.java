package com.erenn.todoapp.User.DTOs;

import jakarta.validation.constraints.NotNull;

public record UserUpdateUsernameDTO(
        @NotNull String username
) {
}
