package org.acme.dto;

import java.util.List;

public record EventDetailDto(
        Long id,
        String name,
        String description,
        String location,
        List<SessionDto> sessions
) {}