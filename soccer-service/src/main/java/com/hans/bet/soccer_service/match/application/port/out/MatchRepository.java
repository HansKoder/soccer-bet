package com.hans.bet.soccer_service.match.application.port.out;

import com.hans.bet.soccer_service.match.domain.model.entity.Match;

import java.util.Optional;
import java.util.UUID;

public interface MatchRepository {
    void save(Match domain);
    Optional<Match> get(UUID uuid);
}
