package com.Twoeye.fincore_backend.domain.transfer.exception;

import com.Twoeye.fincore_backend.domain.common.exception.DomainException;
import com.Twoeye.fincore_backend.domain.transfer.TransferStatus;

public class TransferNotPendingException extends DomainException {

    public TransferNotPendingException(String transferId, TransferStatus status) {
        super("PENDING 상태의 이체만 처리할 수 있습니다. transferId=" + transferId + ", 현재 상태=" + status);
    }
}
