package com.hans.bet.soccer_service.match.application.usecase;

import com.hans.bet.soccer_service.match.application.command.ScheduleMatchCommand;
import com.hans.bet.soccer_service.match.application.port.in.ScheduleMatchUseCase;
import com.hans.bet.soccer_service.match.application.port.out.MatchRepository;
import com.hans.bet.soccer_service.match.domain.model.entity.Match;
import org.springframework.stereotype.Component;

@Component
public class ScheduleMatchUseCaseImpl implements ScheduleMatchUseCase {

    private final MatchRepository matchRepository;

    public ScheduleMatchUseCaseImpl(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    @Override
    public String execute(ScheduleMatchCommand command) {
        Match domain = Match.schedule(command.local(), command.visiting(), command.tournament());
        matchRepository.save(domain);

        return domain.getId().getValue().toString();
    }
}
