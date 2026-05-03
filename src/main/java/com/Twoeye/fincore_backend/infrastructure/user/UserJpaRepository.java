package com.Twoeye.fincore_backend.infrastructure.user;

import com.Twoeye.fincore_backend.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

interface UserJpaRepository extends JpaRepository<User, String> {

    Optional<User> findByLoginId(String loginId);

    boolean existsByLoginId(String loginId);

    boolean existsByPhoneNumber(String phoneNumber);
}

