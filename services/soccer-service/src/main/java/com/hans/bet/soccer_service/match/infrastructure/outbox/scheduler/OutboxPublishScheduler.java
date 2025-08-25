package com.hans.bet.soccer_service.match.infrastructure.outbox.scheduler;

import com.hans.bet.soccer_service.match.application.port.out.MatchOutboxRepository;
import jakarta.transaction.Transactional;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class OutboxPublishScheduler {

    private final MatchOutboxRepository outboxRepository;

    public OutboxPublishScheduler(MatchOutboxRepository outboxRepository) {
        this.outboxRepository = outboxRepository;
    }

    @Transactional
    @Scheduled(fixedRate = 60000)
    public void publish () {
        System.out.println("outbox polling");
        var batch = outboxRepository.getPendingBatch(100);

        for (var outbox : batch) {
            System.out.println("Send to kafka " + outbox);
            outboxRepository.markSent(outbox);
        }
    }
}
