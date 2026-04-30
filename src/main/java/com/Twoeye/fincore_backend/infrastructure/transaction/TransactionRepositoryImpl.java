package com.Twoeye.fincore_backend.infrastructure.transaction;

import com.Twoeye.fincore_backend.domain.transaction.Transaction;
import com.Twoeye.fincore_backend.domain.transaction.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class TransactionRepositoryImpl implements TransactionRepository {

    private final TransactionJpaRepository jpaRepository;

    @Override
    public Transaction save(Transaction transaction) {
        return jpaRepository.save(transaction);
    }

    @Override
    public Optional<Transaction> findById(String transactionId) {
        return jpaRepository.findById(transactionId);
    }

    @Override
    public Page<Transaction> findAllByAccountId(String accountId, Pageable pageable) {
        return jpaRepository.findAllByAccountIdOrderByCreatedAtDesc(accountId, pageable);
    }

    @Override
    public List<Transaction> findAllByTransferId(String transferId) {
        return jpaRepository.findAllByTransferId(transferId);
    }
}
