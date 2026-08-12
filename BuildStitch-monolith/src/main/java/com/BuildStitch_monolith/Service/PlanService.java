package com.BuildStitch_monolith.Service;

import com.BuildStitch_monolith.DTO.Subscription.PlanResponseDTO;

import java.util.List;

public interface PlanService {
    List<PlanResponseDTO> getAllPlans();
}
