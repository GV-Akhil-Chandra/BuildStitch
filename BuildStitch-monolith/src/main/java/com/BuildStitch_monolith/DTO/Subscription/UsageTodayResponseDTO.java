package com.BuildStitch_monolith.DTO.Subscription;

public record UsageTodayResponseDTO(
        Integer tokenUsed,
        Integer tokenLimit,
        Integer previewsRunning,
        Integer previewsLimit
) {
}
