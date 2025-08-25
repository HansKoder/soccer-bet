package com.hans.bet.bet_service.domain.valueobject;

import com.hans.bet.bet_service.shared.domain.model.valueobject.BaseId;

import java.util.UUID;

public class BetId extends BaseId<UUID> {
    public BetId(UUID value) {
        super(value);
    }
}
