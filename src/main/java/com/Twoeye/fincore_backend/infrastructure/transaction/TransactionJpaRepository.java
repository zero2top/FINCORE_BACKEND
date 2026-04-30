package com.Twoeye.fincore_backend.infrastructure.transaction;

import com.Twoeye.fincore_backend.domain.transaction.Transaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

interface TransactionJpaRepository extends JpaRepository<Transaction, String> {

    Page<Transaction> findAllByAccountIdOrderByCreatedAtDesc(String accountId, Pageable pageable);

    List<Transaction> findAllByTransferId(String transferId);
}
