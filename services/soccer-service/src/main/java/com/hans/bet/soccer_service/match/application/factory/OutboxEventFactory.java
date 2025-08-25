package com.hans.bet.soccer_service.match.application.factory;

import com.hans.bet.soccer_service.match.domain.event.ScheduledMatchEvent;
import com.hans.bet.soccer_service.match.domain.model.entity.Match;

import java.time.Instant;

public class OutboxEventFactory {

    public static ScheduledMatchEvent scheduled (Match domain) {
        return new ScheduledMatchEvent(
                domain.getId().getValue().toString(),
                domain.getLocal().name(),
                domain.getVisiting().name(),
                Instant.now()
        );
    }

}
