package com.Twoeye.fincore_backend.infrastructure.transfer;

import com.Twoeye.fincore_backend.domain.transfer.Transfer;
import com.Twoeye.fincore_backend.domain.transfer.TransferRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class TransferRepositoryImpl implements TransferRepository {

    private final TransferJpaRepository jpaRepository;

    @Override
    public Transfer save(Transfer transfer) {
        return jpaRepository.save(transfer);
    }

    @Override
    public Optional<Transfer> findById(String transferId) {
        return jpaRepository.findById(transferId);
    }

    @Override
    public Optional<Transfer> findByIdempotencyKey(String idempotencyKey) {
        return jpaRepository.findByIdempotencyKey(idempotencyKey);
    }

    @Override
    public List<Transfer> findAllByFromAccountId(String fromAccountId) {
        return jpaRepository.findAllByFromAccountId(fromAccountId);
    }
}
