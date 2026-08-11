package com.BuildStitch_monolith.DTO.Project;

import java.time.Instant;

public record ProjectSummaryDTO(
        Long id,
        String name,
        Instant createdAt,
        Instant updatedAt
) {
}
