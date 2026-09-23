package com.company.timertracker.dto;

import com.company.timertracker.enums.RoleName;
import com.company.timertracker.model.User;

import java.time.Instant;
import java.util.Set;

public record UserResponse(
        Long id,
        String username,
        String email,
        boolean enabled,
        Instant createdAt,
        Set<RoleName> roles
) {
    public static UserResponse from(User user) {
        Set<RoleName> roleNames = user.getRoles().stream()
                .map(r -> r.getName())
                .collect(java.util.stream.Collectors.toSet());

        return new UserResponse(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.isEnabled(),
                user.getCreatedAt(),
                roleNames
        );
    }
}