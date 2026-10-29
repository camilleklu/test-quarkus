package org.acme.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.Instant;

public record CreateSessionRequest(
        Long id,

        @NotBlank(message = "Title cannot be blank")
        String title,
        @NotNull(message = "Start Time cannot be null")
        Instant startAt,
        @NotNull(message = "End Time cannot be null")
        Instant endAt
) {}
