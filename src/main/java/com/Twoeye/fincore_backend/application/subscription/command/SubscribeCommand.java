package com.Twoeye.fincore_backend.application.subscription.command;

import java.math.BigDecimal;
import java.time.LocalDate;

public record SubscribeCommand(
        String productId,
        String userId,
        String accountId,
        BigDecimal amount,
        LocalDate startDate,
        int periodMonths
) {}
