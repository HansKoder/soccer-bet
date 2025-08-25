package com.hans.bet.soccer_service.match.application.usecase;

import com.hans.bet.soccer_service.match.application.command.ScheduleMatchCommand;
import com.hans.bet.soccer_service.match.application.factory.OutboxEventFactory;
import com.hans.bet.soccer_service.match.application.model.OutboxEventModel;
import com.hans.bet.soccer_service.match.application.port.in.ScheduleMatchUseCase;
import com.hans.bet.soccer_service.match.application.port.out.MatchOutboxRepository;
import com.hans.bet.soccer_service.match.application.port.out.MatchRepository;
import com.hans.bet.soccer_service.match.domain.model.entity.Match;
import com.hans.bet.soccer_service.match.infrastructure.outbox.persistence.entity.OutboxStatus;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class ScheduleMatchUseCaseImpl implements ScheduleMatchUseCase {

    private final MatchRepository matchRepository;
    private final MatchOutboxRepository outboxRepository;
    private final PayloadSerializer payloadSerializer;

    public ScheduleMatchUseCaseImpl(MatchRepository matchRepository, MatchOutboxRepository outboxRepository, PayloadSerializer payloadSerializer) {
        this.matchRepository = matchRepository;
        this.outboxRepository = outboxRepository;
        this.payloadSerializer = payloadSerializer;
    }

    @Transactional
    @Override
    public String execute(ScheduleMatchCommand command) {
        Match domain = Match.schedule(command.local(), command.visiting(), command.tournament());
        matchRepository.save(domain);

        saveOutboxEvent(domain);

        return domain.getId().getValue().toString();
    }

    private void saveOutboxEvent (Match domain) {
        System.out.println("Save Outbox Event..");
        var domainEvent = OutboxEventFactory.scheduled(domain);
        String payload = payloadSerializer.toJson(domainEvent);
        System.out.println("payload " + payload);

        outboxRepository.save(new OutboxEventModel(
                domainEvent.aggregateId(),
                domainEvent.aggregate(),
                domainEvent.eventType(),
                Instant.now(),
                OutboxStatus.STARTED.name(),
                payload
        ));
    }
}
