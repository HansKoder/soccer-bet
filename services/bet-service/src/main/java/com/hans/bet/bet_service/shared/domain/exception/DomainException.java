package com.hans.bet.bet_service.shared.domain.exception;

public class DomainException extends RuntimeException{
    public DomainException() {
    }

    public DomainException(String message) {
        super(message);
    }
}
