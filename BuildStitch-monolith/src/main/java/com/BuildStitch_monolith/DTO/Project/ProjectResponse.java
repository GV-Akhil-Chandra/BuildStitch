package com.BuildStitch_monolith.DTO.Project;

import com.BuildStitch_monolith.DTO.Auth.UserProfileDTO;

import java.time.Instant;

public record ProjectResponse(
        Long id,
        String name,
        Instant createdAt,
        Instant updatedAt,
        UserProfileDTO owner
) {
}
