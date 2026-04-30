package com.Twoeye.fincore_backend.domain.common.exception;

public abstract class EntityNotFoundException extends DomainException {

    protected EntityNotFoundException(String message) {
        super(message);
    }
}
