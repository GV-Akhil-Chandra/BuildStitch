package com.BuildStitch_monolith.DTO.Subscription;

public record UsageTodayResponseDTO(
        int tokenUsed,
        int tokenLimit,
        int previewsRunning,
        int previewsLimit
) {
}
