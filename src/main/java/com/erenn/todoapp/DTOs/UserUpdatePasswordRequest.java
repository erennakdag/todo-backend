package com.erenn.todoapp.DTOs;

import jakarta.validation.constraints.NotNull;

public record UserUpdatePasswordRequest(
        @NotNull String password
) {
}
