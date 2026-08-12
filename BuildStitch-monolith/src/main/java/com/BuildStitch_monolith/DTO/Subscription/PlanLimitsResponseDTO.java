package com.BuildStitch_monolith.DTO.Subscription;

public record PlanLimitsResponseDTO(
        String planName,
        Integer maxTokenPerDay,
        Integer maxProjects,
        Boolean unlimitedAi
) {
}
