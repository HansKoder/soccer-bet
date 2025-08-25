package com.hans.bet.soccer_service.match.presentation.exception;

import com.hans.bet.soccer_service.match.domain.model.exception.MatchNotFoundException;
import com.hans.bet.soccer_service.match.domain.model.exception.SoccerDomainException;
import com.hans.bet.soccer_service.shared.presentation.exception.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalMatchException {

    @ExceptionHandler(value = {SoccerDomainException.class})
    public ResponseEntity<ErrorResponse> soccerDomainExceptionHandler (SoccerDomainException ex) {
        return ResponseEntity.unprocessableEntity()
                .body(new ErrorResponse(
                        String.valueOf(HttpStatus.CONFLICT),
                        ex.getMessage()));
    }

    @ExceptionHandler(value = {MatchNotFoundException.class})
    public ResponseEntity<ErrorResponse> mathNotFoundExceptionHandler (MatchNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ErrorResponse(
                        String.valueOf(HttpStatus.NOT_FOUND),
                        ex.getMessage()));
    }

}
