package com.Twoeye.fincore_backend.presentation.subscription.dto;

import com.Twoeye.fincore_backend.application.subscription.command.SubscribeCommand;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.time.LocalDate;

public record SubscribeRequest(
        @NotBlank(message = "상품 ID는 필수입니다.")
        String productId,

        @NotBlank(message = "사용자 ID는 필수입니다.")
        String userId,

        @NotBlank(message = "계좌 ID는 필수입니다.")
        String accountId,

        @NotNull
        @Positive(message = "가입 금액은 양수여야 합니다.")
        BigDecimal amount,

        @NotNull(message = "가입 시작일은 필수입니다.")
        LocalDate startDate,

        @Positive(message = "가입 기간은 양수여야 합니다.")
        int periodMonths
) {
    public SubscribeCommand toCommand() {
        return new SubscribeCommand(productId, userId, accountId, amount, startDate, periodMonths);
    }
}
