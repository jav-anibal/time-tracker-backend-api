package com.company.timertracker.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UserCreateRequest(

        @NotBlank
        @Size(min = 3, max = 64)
        String username,

        @NotBlank
        @Email
        @Size(max = 128)
        String email,

        @NotBlank
        @Size(min = 8, max = 72)
        String password
) {}