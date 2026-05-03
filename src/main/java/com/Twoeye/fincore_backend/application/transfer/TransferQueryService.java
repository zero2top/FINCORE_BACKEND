package com.Twoeye.fincore_backend.application.transfer;

import com.Twoeye.fincore_backend.domain.transfer.Transfer;
import com.Twoeye.fincore_backend.domain.transfer.TransferRepository;
import com.Twoeye.fincore_backend.domain.transfer.exception.TransferNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class TransferQueryService {

    private final TransferRepository transferRepository;

    public Transfer getTransfer(String transferId) {
        return transferRepository.findById(transferId)
                .orElseThrow(() -> new TransferNotFoundException(transferId));
    }

    public List<Transfer> getTransfersByFromAccountId(String fromAccountId) {
        return transferRepository.findAllByFromAccountId(fromAccountId);
    }
}
