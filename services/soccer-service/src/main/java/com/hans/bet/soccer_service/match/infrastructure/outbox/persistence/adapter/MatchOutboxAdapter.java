package com.hans.bet.soccer_service.match.infrastructure.outbox.persistence.adapter;

import com.hans.bet.soccer_service.match.application.model.OutboxEventModel;
import com.hans.bet.soccer_service.match.application.port.out.MatchOutboxRepository;
import com.hans.bet.soccer_service.match.infrastructure.outbox.persistence.entity.OutboxEventEntity;
import com.hans.bet.soccer_service.match.infrastructure.outbox.persistence.entity.OutboxStatus;
import com.hans.bet.soccer_service.match.infrastructure.outbox.persistence.mapper.OutboxMapper;
import com.hans.bet.soccer_service.match.infrastructure.outbox.persistence.repository.JpaOutboxEventRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MatchOutboxAdapter implements MatchOutboxRepository {

    private final JpaOutboxEventRepository repository;

    public MatchOutboxAdapter(JpaOutboxEventRepository repository) {
        this.repository = repository;
    }

    @Override
    public void save(OutboxEventModel model) {
        repository.save(OutboxMapper.toEntity(model));
    }

    @Override
    public List<OutboxEventModel> getPendingBatch(int size) {
        System.out.println("Pending Batching");
        return repository.findByStatus(OutboxStatus.STARTED)
                .stream().map(OutboxMapper::toModel).toList();
    }

    @Override
    public void clean() {
        System.out.println("Clean");
    }

    @Override
    public void markSent(OutboxEventModel model) {
        OutboxEventEntity outbox = OutboxMapper.toEntity(model);
        outbox.setStatus(OutboxStatus.COMPLETED);
        repository.save(outbox);
    }
}
