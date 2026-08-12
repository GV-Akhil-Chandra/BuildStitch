package com.BuildStitch_monolith.DTO.Subscription;

public record PlanLimitsResponseDTO(
        String planName,
        int maxTokenPerDay,
        int maxProjects,
        boolean unlimitedAi
) {
}
