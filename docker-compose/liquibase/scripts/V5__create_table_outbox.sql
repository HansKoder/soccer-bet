create table OUTBOX_EVENTS (
    id BIGSERIAL PRIMARY KEY,
    created_at TIMESTAMP WITH TIME ZONE,
    aggregate_id VARCHAR(200),
    aggregate_name VARCHAR(20),
    event_type VARCHAR(20),
    payload TEXT,
    outbox_status VARCHAR(20) NOT NULL CHECK (outbox_status IN ('STARTED', 'COMPLETED', 'FAILED'))
);