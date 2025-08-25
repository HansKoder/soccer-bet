package com.hans.bet.soccer_service.match.domain.event;

import java.time.Instant;

public record ScheduledMatchEvent(String matchId, String teamA, String teamB, Instant schedule) implements MatchDetailEvent {
    @Override
    public String eventType() {
        return "SCHEDULED_MATCH_EVENT";
    }

    @Override
    public String aggregate() {
        return "MATCH";
    }

    @Override
    public String aggregateId() {
        return matchId;
    }
}
