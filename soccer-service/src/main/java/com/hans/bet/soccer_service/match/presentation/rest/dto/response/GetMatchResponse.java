package com.hans.bet.soccer_service.match.presentation.rest.dto.response;

public record GetMatchResponse (
        String uuid,
        String local,
        String visiting,
        String tournament,
        String status
) { }
