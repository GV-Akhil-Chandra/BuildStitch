package com.BuildStitch_monolith.Controller;

import com.BuildStitch_monolith.DTO.Subscription.CheckoutRequestDTO;
import com.BuildStitch_monolith.DTO.Subscription.CheckoutResponseDTO;
import com.BuildStitch_monolith.DTO.Subscription.PlanResponseDTO;
import com.BuildStitch_monolith.DTO.Subscription.SubscriptionResponseDTO;
import com.BuildStitch_monolith.Service.PlanService;
import com.BuildStitch_monolith.Service.SubscriptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/billing")
@RequiredArgsConstructor
public class BillingController {

    private final PlanService planService;
    private final SubscriptionService subscriptionService;

    @GetMapping("/plans")
    public ResponseEntity<List<PlanResponseDTO>> getAllPlans(){
        return ResponseEntity.ok(planService.getAllPlans());
    }

    @GetMapping("/me/subscription")
    public ResponseEntity<SubscriptionResponseDTO> getCurrentUserPlan(){
        Long userId = 1L;
        return ResponseEntity.ok(subscriptionService.getCurrentSubscription(userId));
    }

    @PostMapping("/checkout")
    public ResponseEntity<CheckoutResponseDTO> createCheckoutResponse(@RequestBody CheckoutRequestDTO request){
        Long userId = 1L;
        return ResponseEntity.ok(subscriptionService.createCheckoutSessionUrl(request));
    }


}
