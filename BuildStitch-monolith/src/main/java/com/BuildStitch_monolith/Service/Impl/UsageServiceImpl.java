package com.BuildStitch_monolith.Service.Impl;

import com.BuildStitch_monolith.DTO.Subscription.PlanLimitsResponseDTO;
import com.BuildStitch_monolith.DTO.Subscription.UsageTodayResponseDTO;
import com.BuildStitch_monolith.Service.UsageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsageServiceImpl implements UsageService {
    @Override
    public UsageTodayResponseDTO getUserTodayUsage(Long userId) {
        return null;
    }

    @Override
    public PlanLimitsResponseDTO getUserSubscriptionLimits(Long userId) {
        return null;
    }
}
