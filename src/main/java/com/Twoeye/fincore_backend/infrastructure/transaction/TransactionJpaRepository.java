package com.Twoeye.fincore_backend.infrastructure.transaction;

import com.Twoeye.fincore_backend.domain.transaction.Transaction;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

interface TransactionJpaRepository extends JpaRepository<Transaction, String> {

    @Query("SELECT t FROM Transaction t WHERE t.accountId = :accountId AND (:cursor IS NULL OR t.createdAt < :cursor) ORDER BY t.createdAt DESC")
    List<Transaction> findCursorByAccountId(
            @Param("accountId") String accountId,
            @Param("cursor") LocalDateTime cursor,
            Pageable pageable
    );

    List<Transaction> findAllByTransferId(String transferId);
}
