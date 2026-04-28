package com.Twoeye.fincore_backend.presentation.account.dto;

import com.Twoeye.fincore_backend.domain.account.Account;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record AccountResponse(
        String accountId,
        String accountNumber,
        String userId,
        String productId,
        BigDecimal balance,
        BigDecimal dailyTransferAmount,
        String status,
        LocalDateTime createdAt
) {
    public static AccountResponse from(Account account) {
        return new AccountResponse(
                account.getAccountId(),
                account.getAccountNumber(),
                account.getUserId(),
                account.getProductId(),
                account.getBalance(),
                account.getDailyTransferAmount(),
                account.getStatus().name(),
                account.getCreatedAt()
        );
    }
}
