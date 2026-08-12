package com.BuildStitch_monolith.Service.Impl;

import com.BuildStitch_monolith.DTO.Subscription.CheckoutRequestDTO;
import com.BuildStitch_monolith.DTO.Subscription.CheckoutResponseDTO;
import com.BuildStitch_monolith.DTO.Subscription.SubscriptionResponseDTO;
import com.BuildStitch_monolith.Service.SubscriptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SubscriptionServiceImpl implements SubscriptionService {
    @Override
    public SubscriptionResponseDTO getCurrentSubscription(Long userId) {
        return null;
    }

    @Override
    public CheckoutResponseDTO createCheckoutSessionUrl(CheckoutRequestDTO request) {
        return null;
    }
}
