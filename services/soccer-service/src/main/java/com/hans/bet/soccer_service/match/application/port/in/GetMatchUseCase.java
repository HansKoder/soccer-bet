package com.hans.bet.soccer_service.match.application.port.in;

import com.hans.bet.soccer_service.match.domain.model.entity.Match;

public interface GetMatchUseCase {
    Match execute (String uuid);
}
