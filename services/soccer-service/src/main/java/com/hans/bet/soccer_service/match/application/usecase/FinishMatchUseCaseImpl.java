package com.hans.bet.soccer_service.match.application.usecase;

import com.hans.bet.soccer_service.match.application.port.in.FinishMatchUseCase;
import com.hans.bet.soccer_service.match.application.port.in.StartMatchUseCase;
import com.hans.bet.soccer_service.match.application.port.out.MatchRepository;
import com.hans.bet.soccer_service.match.domain.model.entity.Match;
import com.hans.bet.soccer_service.match.domain.model.exception.MatchNotFoundException;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class FinishMatchUseCaseImpl implements FinishMatchUseCase {

    private final MatchRepository matchRepository;

    public FinishMatchUseCaseImpl(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    @Override
    public void execute(String matchId) {
        Match domain = matchRepository.get(UUID.fromString(matchId))
                .orElseThrow(() -> new MatchNotFoundException("Match with the ID " + matchId + " is not found"));

        domain.finish();

        matchRepository.save(domain);
    }
}
