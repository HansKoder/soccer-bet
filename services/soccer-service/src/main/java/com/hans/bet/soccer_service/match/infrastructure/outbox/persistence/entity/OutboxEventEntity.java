package com.hans.bet.soccer_service.match.infrastructure.outbox.persistence.entity;

import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "outbox_events")
public class OutboxEventEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "aggregate_name")
    private String aggregateName;

    @Column(name = "aggregate_id")
    private String aggregateId;

    @Column(name = "event_type")
    private String eventType;

    @Column(name = "created_at")
    private Instant createdAt;

    @Lob
    @Column(columnDefinition = "TEXT")
    private String payload;

    @Enumerated(EnumType.STRING)
    @Column(name = "outbox_status")
    private OutboxStatus status;

    public String getAggregateId() {
        return aggregateId;
    }

    public void setAggregateId(String aggregateId) {
        this.aggregateId = aggregateId;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public String getAggregateName() {
        return aggregateName;
    }

    public void setAggregateName(String aggregateName) {
        this.aggregateName = aggregateName;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OutboxStatus getStatus() {
        return status;
    }

    public void setStatus(OutboxStatus status) {
        this.status = status;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }

    @Override
    public String toString() {
        return "OutboxEventEntity{" +
                "aggregateId='" + aggregateId + '\'' +
                ", id=" + id +
                ", aggregateName='" + aggregateName + '\'' +
                ", eventType='" + eventType + '\'' +
                ", createdAt=" + createdAt +
                ", payload='" + payload + '\'' +
                ", status=" + status +
                '}';
    }
}
