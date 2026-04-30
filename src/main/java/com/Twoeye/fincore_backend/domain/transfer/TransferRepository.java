package com.Twoeye.fincore_backend.domain.transfer;

import java.util.List;
import java.util.Optional;

public interface TransferRepository {

    Transfer save(Transfer transfer);

    Optional<Transfer> findById(String transferId);

    Optional<Transfer> findByIdempotencyKey(String idempotencyKey);

    List<Transfer> findAllByFromAccountId(String fromAccountId);
}
