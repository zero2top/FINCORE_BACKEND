package com.Twoeye.fincore_backend.application.transfer.command;

import java.math.BigDecimal;

public record TransferCommand(
        String fromAccountId,
        String toAccountNumber,
        BigDecimal amount,
        String idempotencyKey
) {}
