package com.hans.bet.soccer_service.match.infra.client.rest;

import com.hans.bet.soccer_service.match.application.command.ScheduleMatchCommand;
import com.hans.bet.soccer_service.match.application.port.in.GetMatchUseCase;
import com.hans.bet.soccer_service.match.application.port.in.ScheduleMatchUseCase;
import com.hans.bet.soccer_service.match.infra.client.rest.dto.request.CreateMatchRequest;
import com.hans.bet.soccer_service.match.infra.client.rest.dto.response.GetMatchResponse;
import com.hans.bet.soccer_service.match.infra.client.rest.mapper.MatchRestMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@RestController
@RequestMapping("/api/v1/match")
public class MatchController {

    private final ScheduleMatchUseCase scheduleMatchUseCase;
    private final GetMatchUseCase getMatchUseCase;

    public MatchController(ScheduleMatchUseCase scheduleMatchUseCase, GetMatchUseCase getMatchUseCase) {
        this.scheduleMatchUseCase = scheduleMatchUseCase;
        this.getMatchUseCase = getMatchUseCase;
    }

    @PostMapping("/schedule")
    ResponseEntity<?> scheduleMatch (@RequestBody CreateMatchRequest request){
        String uuid = scheduleMatchUseCase
                .execute(new ScheduleMatchCommand(request.local(), request.visiting(), request.tournament()));

        return ResponseEntity.ok(Collections.singletonMap("msg", "Schedule match with success, ID " + uuid));
    }

    @GetMapping("/{uuid}")
    @CrossOrigin(origins = "http://localhost:3000")
    ResponseEntity<?> getMatch (@PathVariable("uuid") String uuid) {
        GetMatchResponse response = MatchRestMapper.toResponse(getMatchUseCase.execute(uuid));
        return ResponseEntity.ok(response);

    }

}
