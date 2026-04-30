package com.Twoeye.fincore_backend.domain.transfer.exception;

import com.Twoeye.fincore_backend.domain.common.exception.EntityNotFoundException;

public class TransferNotFoundException extends EntityNotFoundException {

    public TransferNotFoundException(String transferId) {
        super("이체 내역을 찾을 수 없습니다. transferId=" + transferId);
    }
}
