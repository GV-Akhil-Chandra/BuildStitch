package com.BuildStitch_monolith.Service.Impl;

import com.BuildStitch_monolith.DTO.Subscription.PlanResponseDTO;
import com.BuildStitch_monolith.Service.PlanService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlanServiceImpl implements PlanService {
    @Override
    public List<PlanResponseDTO> getAllPlans() {
        return List.of();
    }
}
