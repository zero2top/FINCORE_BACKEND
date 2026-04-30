package com.Twoeye.fincore_backend.infrastructure.subscription;

import com.Twoeye.fincore_backend.domain.subscription.ProductSubscription;
import com.Twoeye.fincore_backend.domain.subscription.ProductSubscriptionRepository;
import com.Twoeye.fincore_backend.domain.subscription.SubscriptionStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ProductSubscriptionRepositoryImpl implements ProductSubscriptionRepository {

    private final ProductSubscriptionJpaRepository jpaRepository;

    @Override
    public ProductSubscription save(ProductSubscription subscription) {
        return jpaRepository.save(subscription);
    }

    @Override
    public Optional<ProductSubscription> findById(String subscriptionId) {
        return jpaRepository.findById(subscriptionId);
    }

    @Override
    public List<ProductSubscription> findAllByUserId(String userId) {
        return jpaRepository.findAllByUserId(userId);
    }

    @Override
    public List<ProductSubscription> findAllByAccountId(String accountId) {
        return jpaRepository.findAllByAccountId(accountId);
    }

    @Override
    public List<ProductSubscription> findAllByStatus(SubscriptionStatus status) {
        return jpaRepository.findAllByStatus(status);
    }

    @Override
    public List<ProductSubscription> findAllRenewableByDate(LocalDate date) {
        return jpaRepository.findAllByStatusAndNextRenewAtLessThanEqual(SubscriptionStatus.ACTIVE, date);
    }
}
