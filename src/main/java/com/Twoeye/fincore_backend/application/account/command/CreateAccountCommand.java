package com.Twoeye.fincore_backend.application.account.command;

import java.math.BigDecimal;

public record CreateAccountCommand(
        String userId,
        String productId,
        BigDecimal dailyTransferLimit
) {
}
