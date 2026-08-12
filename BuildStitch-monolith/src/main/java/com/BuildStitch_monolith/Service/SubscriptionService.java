package com.BuildStitch_monolith.Service;

import com.BuildStitch_monolith.DTO.Subscription.CheckoutRequestDTO;
import com.BuildStitch_monolith.DTO.Subscription.CheckoutResponseDTO;
import com.BuildStitch_monolith.DTO.Subscription.SubscriptionResponseDTO;

public interface SubscriptionService {
    SubscriptionResponseDTO getCurrentSubscription(Long userId);

    CheckoutResponseDTO createCheckoutSessionUrl(CheckoutRequestDTO request);
}
