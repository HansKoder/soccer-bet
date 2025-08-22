package com.hans.bet.soccer_service.match.domain.model.exception;

import com.hans.bet.soccer_service.shared.domain.exception.DomainException;

public class MatchNotFoundException extends DomainException {
    public MatchNotFoundException(String message) {
        super(message);
    }
}
