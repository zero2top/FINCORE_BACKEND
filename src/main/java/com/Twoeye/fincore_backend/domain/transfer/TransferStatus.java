package com.Twoeye.fincore_backend.domain.transfer;

public enum TransferStatus {
    PENDING,    // 이체 요청됨 (처리 대기)
    COMPLETED,  // 이체 성공
    FAILED      // 이체 실패 (fail_reason 컬럼이 있는 게 힌트)
}
