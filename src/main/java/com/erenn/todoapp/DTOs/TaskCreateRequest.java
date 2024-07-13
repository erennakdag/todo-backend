package com.erenn.todoapp.DTOs;

import jakarta.validation.constraints.NotNull;

import java.time.Instant;
import java.util.UUID;

public record TaskCreateRequest(
        @NotNull
        UUID user,

        @NotNull
        String text,

        Instant dueDate
) {
}
