package com.hans.bet.soccer_service.match.application.model;

import java.time.Instant;

public class OutboxEventModel {
    private final String aggregateId;
    private final String aggregateName;
    private final String eventType;
    private final Instant createdAt;
    private String status;
    private final String payload;

    public OutboxEventModel(String aggregateId, String aggregateName, String eventType, Instant createdAt, String status, String payload) {
        this.aggregateId = aggregateId;
        this.aggregateName = aggregateName;
        this.eventType = eventType;
        this.createdAt = createdAt;
        this.status = status;
        this.payload = payload;
    }

    public String getAggregateId() {
        return aggregateId;
    }

    public String getAggregateName() {
        return aggregateName;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public String getEventType() {
        return eventType;
    }

    public String getPayload() {
        return payload;
    }

    public String getStatus() {
        return status;
    }

    public void markSent () {
        this.status = "COMPLETED";
    }

    @Override
    public String toString() {
        return "OutboxEventModel{" +
                "aggregateId='" + aggregateId + '\'' +
                ", aggregateName='" + aggregateName + '\'' +
                ", eventType='" + eventType + '\'' +
                ", createdAt=" + createdAt +
                ", status='" + status + '\'' +
                ", payload='" + payload + '\'' +
                '}';
    }
}

