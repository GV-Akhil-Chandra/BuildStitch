package com.BuildStitch_monolith.DTO.Subscription;

import java.time.Instant;

public record SubscriptionResponseDTO(
        PlanResponseDTO plan,
        String status,
        Instant periodEnd,
        Long tokenUsed
) {
}
