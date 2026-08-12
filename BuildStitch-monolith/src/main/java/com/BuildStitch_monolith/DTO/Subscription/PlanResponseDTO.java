package com.BuildStitch_monolith.DTO.Subscription;

public record PlanResponseDTO(
        String name,
        String billingPriceId, // stripe's billing custom id for each plan
        Integer maxProjects,
        Integer maxTokensPerDay,
        Integer maxPreviews,
        Boolean unlimitedAi, // to ignore maxTokenPerDay
        Boolean isActive
) {
}
