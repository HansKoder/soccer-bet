package com.hans.bet.soccer_service.match.infrastructure.outbox.persistence.repository;

import com.hans.bet.soccer_service.match.infrastructure.outbox.persistence.entity.OutboxEventEntity;
import com.hans.bet.soccer_service.match.infrastructure.outbox.persistence.entity.OutboxStatus;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JpaOutboxEventRepository extends CrudRepository<OutboxEventEntity, Long> {
    List<OutboxEventEntity> findByStatus(OutboxStatus status);
}
