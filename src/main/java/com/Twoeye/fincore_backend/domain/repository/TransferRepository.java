package com.Twoeye.fincore_backend.domain.repository;

import com.Twoeye.fincore_backend.domain.transfer.Transfer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransferRepository extends JpaRepository<Transfer,String> {

}
