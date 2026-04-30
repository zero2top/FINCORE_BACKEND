package com.Twoeye.fincore_backend.domain.subscription;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ProductSubscriptionRepository {

    ProductSubscription save(ProductSubscription subscription);

    Optional<ProductSubscription> findById(String subscriptionId);

    List<ProductSubscription> findAllByUserId(String userId);

    List<ProductSubscription> findAllByAccountId(String accountId);

    List<ProductSubscription> findAllByStatus(SubscriptionStatus status);

    List<ProductSubscription> findAllRenewableByDate(LocalDate date);
}
