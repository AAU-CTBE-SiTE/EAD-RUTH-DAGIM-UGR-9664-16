package com.site.actor_management.dto;

import jakarta.validation.constraints.NotBlank;

public record ActorRequest(
        @NotBlank(message = "name is required") String name,
        @NotBlank(message = "movieName is required") String movieName) {
}