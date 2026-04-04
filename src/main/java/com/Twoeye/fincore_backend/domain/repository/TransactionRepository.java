package com.Twoeye.fincore_backend.domain.repository;

import com.Twoeye.fincore_backend.domain.transaction.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, String> {

}

