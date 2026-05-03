package com.Twoeye.fincore_backend.infrastructure.transaction;

import com.Twoeye.fincore_backend.domain.transaction.Transaction;
import com.Twoeye.fincore_backend.domain.transaction.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
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
    public List<Transaction> findAllByAccountId(String accountId, LocalDateTime cursor, int size) {
        return jpaRepository.findCursorByAccountId(accountId, cursor, PageRequest.of(0, size));
    }

    @Override
    public List<Transaction> findAllByTransferId(String transferId) {
        return jpaRepository.findAllByTransferId(transferId);
    }
}
