package org.acme.dto;

import java.time.Instant;

public record SessionDto(
        Long id,
        String title,
        Instant startAt,
        Instant endAt
) {}