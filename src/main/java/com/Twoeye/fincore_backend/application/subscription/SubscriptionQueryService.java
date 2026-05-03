package com.Twoeye.fincore_backend.application.subscription;

import com.Twoeye.fincore_backend.domain.subscription.ProductSubscription;
import com.Twoeye.fincore_backend.domain.subscription.ProductSubscriptionRepository;
import com.Twoeye.fincore_backend.domain.subscription.exception.SubscriptionNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class SubscriptionQueryService {

    private final ProductSubscriptionRepository subscriptionRepository;

    public ProductSubscription getSubscription(String subscriptionId) {
        return subscriptionRepository.findById(subscriptionId)
                .orElseThrow(() -> new SubscriptionNotFoundException(subscriptionId));
    }

    public List<ProductSubscription> getSubscriptionsByUserId(String userId) {
        return subscriptionRepository.findAllByUserId(userId);
    }

    public List<ProductSubscription> getSubscriptionsByAccountId(String accountId) {
        return subscriptionRepository.findAllByAccountId(accountId);
    }
}
