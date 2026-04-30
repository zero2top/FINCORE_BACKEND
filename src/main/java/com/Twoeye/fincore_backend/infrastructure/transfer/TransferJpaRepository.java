package com.Twoeye.fincore_backend.infrastructure.transfer;

import com.Twoeye.fincore_backend.domain.transfer.Transfer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

interface TransferJpaRepository extends JpaRepository<Transfer, String> {

    Optional<Transfer> findByIdempotencyKey(String idempotencyKey);

    List<Transfer> findAllByFromAccountId(String fromAccountId);
}
