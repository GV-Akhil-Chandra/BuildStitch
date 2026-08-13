package com.BuildStitch_monolith.Controller;

import com.BuildStitch_monolith.DTO.Subscription.PlanLimitsResponseDTO;
import com.BuildStitch_monolith.DTO.Subscription.UsageTodayResponseDTO;
import com.BuildStitch_monolith.Service.UsageService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usage")
@RequiredArgsConstructor
public class UsageController {
    private final UsageService usageService;

    @GetMapping("/today")
    public ResponseEntity<UsageTodayResponseDTO> todayUsage(){
        Long userId = 1L;
        return ResponseEntity.ok(usageService.getUserTodayUsage(userId));
    }

    @GetMapping("/plan-limits")
    public ResponseEntity<PlanLimitsResponseDTO> getPlanLimits(){
        Long userId = 1L;
        return ResponseEntity.ok(usageService.getUserSubscriptionLimits(userId));
    }
}
