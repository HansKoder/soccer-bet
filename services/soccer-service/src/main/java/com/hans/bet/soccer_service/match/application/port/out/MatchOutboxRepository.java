package com.hans.bet.soccer_service.match.application.port.out;

import com.hans.bet.soccer_service.match.application.model.OutboxEventModel;

import java.util.List;

public interface MatchOutboxRepository {
    void save(OutboxEventModel model);
    List<OutboxEventModel> getPendingBatch (int size);
    void clean ();
    void markSent (OutboxEventModel model);
}
