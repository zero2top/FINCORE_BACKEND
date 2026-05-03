package com.Twoeye.fincore_backend.domain.transaction;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface TransactionRepository {

    Transaction save(Transaction transaction);

    Optional<Transaction> findById(String transactionId);

    // cursor: null이면 첫 페이지, size+1개 조회해서 hasNext 판별
    List<Transaction> findAllByAccountId(String accountId, LocalDateTime cursor, int size);

    List<Transaction> findAllByTransferId(String transferId);
}
