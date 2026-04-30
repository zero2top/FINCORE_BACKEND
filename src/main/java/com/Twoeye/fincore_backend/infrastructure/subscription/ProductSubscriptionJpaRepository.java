package com.Twoeye.fincore_backend.infrastructure.subscription;

import com.Twoeye.fincore_backend.domain.subscription.ProductSubscription;
import com.Twoeye.fincore_backend.domain.subscription.SubscriptionStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

interface ProductSubscriptionJpaRepository extends JpaRepository<ProductSubscription, String> {

    List<ProductSubscription> findAllByUserId(String userId);

    List<ProductSubscription> findAllByAccountId(String accountId);

    List<ProductSubscription> findAllByStatus(SubscriptionStatus status);

    List<ProductSubscription> findAllByStatusAndNextRenewAtLessThanEqual(SubscriptionStatus status, LocalDate date);
}
