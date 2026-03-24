package com.Twoeye.fincore_backend.repository;

import com.Twoeye.fincore_backend.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, String> {

}

