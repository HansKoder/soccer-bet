package com.hans.bet.soccer_service.match.infrastructure.outbox.persistence.mapper;

import com.hans.bet.soccer_service.match.application.model.OutboxEventModel;
import com.hans.bet.soccer_service.match.infrastructure.outbox.persistence.entity.OutboxEventEntity;
import com.hans.bet.soccer_service.match.infrastructure.outbox.persistence.entity.OutboxStatus;

public class OutboxMapper {

    public static OutboxEventEntity toEntity(OutboxEventModel model) {
        OutboxEventEntity entity = new OutboxEventEntity();

        entity.setAggregateId(model.getAggregateId());
        entity.setAggregateName(model.getAggregateName());
        entity.setPayload(model.getPayload());
        entity.setStatus(OutboxStatus.valueOf(model.getStatus()));
        entity.setCreatedAt(model.getCreatedAt());

        return entity;
    }

    public static OutboxEventModel toModel (OutboxEventEntity entity) {
        return new OutboxEventModel(
                // entity.getId(),
                entity.getAggregateId(),
                entity.getAggregateName(),
                entity.getEventType(),
                entity.getCreatedAt(),
                entity.getStatus().name(),
                entity.getPayload()
        );
    }

}
