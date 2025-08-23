package com.hans.bet.soccer_service.match.domain.model.exception;

import com.hans.bet.soccer_service.shared.domain.exception.DomainException;

public class SoccerDomainException extends DomainException {
    public SoccerDomainException(String message) {
        super(message);
    }
}
