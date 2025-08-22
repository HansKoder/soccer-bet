package com.hans.bet.soccer_service.match.domain.model.exception;

public class SoccerDomainException extends RuntimeException{
    public SoccerDomainException() {
    }

    public SoccerDomainException(String message) {
        super(message);
    }
}
