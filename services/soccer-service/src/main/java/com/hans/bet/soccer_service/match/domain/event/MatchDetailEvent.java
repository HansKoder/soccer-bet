package com.hans.bet.soccer_service.match.domain.event;

public interface MatchDetailEvent {
    String eventType();
    String aggregate();
    String aggregateId();
}
