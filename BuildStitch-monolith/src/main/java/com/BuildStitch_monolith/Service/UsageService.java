package com.BuildStitch_monolith.Service;

import com.BuildStitch_monolith.DTO.Subscription.PlanLimitsResponseDTO;
import com.BuildStitch_monolith.DTO.Subscription.UsageTodayResponseDTO;

public interface UsageService {
    UsageTodayResponseDTO getUserTodayUsage(Long userId);

    PlanLimitsResponseDTO getUserSubscriptionLimits(Long userId);
}
