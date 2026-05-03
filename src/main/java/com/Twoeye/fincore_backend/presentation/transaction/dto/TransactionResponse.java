package com.Twoeye.fincore_backend.presentation.transaction.dto;

import com.Twoeye.fincore_backend.domain.transaction.Transaction;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record TransactionResponse(
        String transactionId,
        String accountId,
        String transferId,
        String type,
        BigDecimal amount,
        BigDecimal balanceAfter,
        String counterparty,
        LocalDateTime createdAt
) {
    public static TransactionResponse from(Transaction transaction) {
        return new TransactionResponse(
                transaction.getTransactionId(),
                transaction.getAccountId(),
                transaction.getTransferId(),
                transaction.getType().name(),
                transaction.getAmount(),
                transaction.getBalanceAfter(),
                transaction.getCounterparty(),
                transaction.getCreatedAt()
        );
    }
}
