package com.Twoeye.fincore_backend.presentation.transfer.dto;

import com.Twoeye.fincore_backend.domain.transfer.Transfer;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record TransferResponse(
        String transferId,
        String fromAccountId,
        String toAccountNumber,
        BigDecimal amount,
        String status,
        String failReason,
        LocalDateTime requestedAt,
        LocalDateTime completedAt
) {
    public static TransferResponse from(Transfer transfer) {
        return new TransferResponse(
                transfer.getTransferId(),
                transfer.getFromAccountId(),
                transfer.getToAccountNumber(),
                transfer.getAmount(),
                transfer.getStatus().name(),
                transfer.getFailReason(),
                transfer.getRequestedAt(),
                transfer.getCompletedAt()
        );
    }
}
