package com.hans.bet.soccer_service.match.domain.model.valueobject;

import com.hans.bet.soccer_service.shared.domain.model.valueobject.BaseId;

import java.util.UUID;

public class MatchId extends BaseId<UUID> {
    public MatchId(UUID value) {
        super(value);
    }
}
