package com.Twoeye.fincore_backend.application.subscription;

import com.Twoeye.fincore_backend.application.subscription.command.SubscribeCommand;
import com.Twoeye.fincore_backend.domain.product.Product;
import com.Twoeye.fincore_backend.domain.product.ProductRepository;
import com.Twoeye.fincore_backend.domain.product.exception.ProductNotFoundException;
import com.Twoeye.fincore_backend.domain.subscription.ProductSubscription;
import com.Twoeye.fincore_backend.domain.subscription.ProductSubscriptionRepository;
import com.Twoeye.fincore_backend.domain.subscription.SubscriptionStatus;
import com.Twoeye.fincore_backend.domain.subscription.exception.SubscriptionAlreadyCancelledException;
import com.Twoeye.fincore_backend.domain.subscription.exception.SubscriptionNotFoundException;
import com.Twoeye.fincore_backend.domain.subscription.exception.SubscriptionNotActiveException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class SubscriptionCommandService {

    private final ProductSubscriptionRepository subscriptionRepository;
    private final ProductRepository productRepository;

    public ProductSubscription subscribe(SubscribeCommand command) {
        Product product = productRepository.findById(command.productId())
                .orElseThrow(() -> new ProductNotFoundException(command.productId()));

        ProductSubscription subscription = ProductSubscription.builder()
                .productId(product.getProductId())
                .userId(command.userId())
                .accountId(command.accountId())
                .amount(command.amount())
                .startDate(command.startDate())
                .maturityDate(command.startDate().plusMonths(command.periodMonths()))
                .status(SubscriptionStatus.ACTIVE)
                .build();

        return subscriptionRepository.save(subscription);
    }

    public void cancel(String subscriptionId) {
        ProductSubscription subscription = subscriptionRepository.findById(subscriptionId)
                .orElseThrow(() -> new SubscriptionNotFoundException(subscriptionId));

        if (subscription.getStatus() == SubscriptionStatus.CANCELLED) {
            throw new SubscriptionAlreadyCancelledException(subscriptionId);
        }
        if (subscription.getStatus() != SubscriptionStatus.ACTIVE) {
            throw new SubscriptionNotActiveException(subscriptionId, subscription.getStatus());
        }

        subscription.cancel();
        subscriptionRepository.save(subscription);
    }
}
