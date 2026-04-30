package com.Twoeye.fincore_backend.domain.transaction;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface TransactionRepository {

    Transaction save(Transaction transaction);

    Optional<Transaction> findById(String transactionId);

    Page<Transaction> findAllByAccountId(String accountId, Pageable pageable);

    List<Transaction> findAllByTransferId(String transferId);
}
