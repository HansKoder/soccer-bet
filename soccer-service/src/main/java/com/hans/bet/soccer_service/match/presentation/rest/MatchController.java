package com.hans.bet.soccer_service.match.presentation.rest;

import com.hans.bet.soccer_service.match.application.command.ScheduleMatchCommand;
import com.hans.bet.soccer_service.match.application.port.in.FinishMatchUseCase;
import com.hans.bet.soccer_service.match.application.port.in.GetMatchUseCase;
import com.hans.bet.soccer_service.match.application.port.in.ScheduleMatchUseCase;
import com.hans.bet.soccer_service.match.application.port.in.StartMatchUseCase;
import com.hans.bet.soccer_service.match.presentation.rest.dto.request.CreateMatchRequest;
import com.hans.bet.soccer_service.match.presentation.rest.dto.response.GetMatchResponse;
import com.hans.bet.soccer_service.match.presentation.rest.mapper.MatchRestMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@RestController
@RequestMapping("/api/v1/match")
public class MatchController {

    private final ScheduleMatchUseCase scheduleMatchUseCase;
    private final GetMatchUseCase getMatchUseCase;
    private final StartMatchUseCase startMatchUseCase;
    private final FinishMatchUseCase finishMatchUseCase;

    public MatchController(ScheduleMatchUseCase scheduleMatchUseCase, GetMatchUseCase getMatchUseCase, StartMatchUseCase startMatchUseCase, FinishMatchUseCase finishMatchUseCase) {
        this.scheduleMatchUseCase = scheduleMatchUseCase;
        this.getMatchUseCase = getMatchUseCase;
        this.startMatchUseCase = startMatchUseCase;
        this.finishMatchUseCase = finishMatchUseCase;
    }

    @PostMapping("/schedule")
    ResponseEntity<?> scheduleMatch (@RequestBody CreateMatchRequest request){
        String uuid = scheduleMatchUseCase
                .execute(new ScheduleMatchCommand(request.local(), request.visiting(), request.tournament()));

        return ResponseEntity.ok(Collections.singletonMap("msg", "Schedule match with success, ID " + uuid));
    }

    @GetMapping("/{matchId}")
    ResponseEntity<?> getMatch (@PathVariable("matchId") String matchId ) {
        GetMatchResponse response = MatchRestMapper.toResponse(getMatchUseCase.execute(matchId));
        return ResponseEntity.ok(response);

    }

    @PutMapping("/start/{matchId}")
    ResponseEntity<?> startMatch (@PathVariable("matchId") String matchId ) {
        startMatchUseCase.execute(matchId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/finish/{matchId}")
    ResponseEntity<?> finishMatch (@PathVariable("matchId") String matchId ) {
        finishMatchUseCase.execute(matchId);
        return ResponseEntity.noContent().build();
    }

}
