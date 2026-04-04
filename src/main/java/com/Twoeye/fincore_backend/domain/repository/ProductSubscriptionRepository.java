package com.Twoeye.fincore_backend.domain.repository;

import com.Twoeye.fincore_backend.domain.subscription.ProductSubscription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductSubscriptionRepository extends JpaRepository<ProductSubscription,String> {

}
