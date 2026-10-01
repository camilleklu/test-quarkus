package org.acme.dto;

import jakarta.validation.constraints.NotBlank;

public record CreateEventRequest (

        @NotBlank(message = "Name cannot be blank")
        String name,

        @NotBlank(message = "Name cannot be blank")
        String description,

        @NotBlank(message = "Name cannot be blank")
        String location
){}
