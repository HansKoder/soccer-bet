package com.hans.bet.soccer_service.match.application.usecase;

import com.hans.bet.soccer_service.match.application.port.in.GetMatchUseCase;
import com.hans.bet.soccer_service.match.application.port.out.MatchRepository;
import com.hans.bet.soccer_service.match.domain.model.entity.Match;
import com.hans.bet.soccer_service.match.domain.model.exception.MatchNotFoundException;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class GetMatchUseCaseImpl implements GetMatchUseCase {

    private final MatchRepository matchRepository;

    public GetMatchUseCaseImpl(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    @Override
    public Match execute(String uuid) {
        return matchRepository.get(UUID.fromString(uuid))
                .orElseThrow(() -> new MatchNotFoundException("Match is not found with the id " + uuid));
    }
}
