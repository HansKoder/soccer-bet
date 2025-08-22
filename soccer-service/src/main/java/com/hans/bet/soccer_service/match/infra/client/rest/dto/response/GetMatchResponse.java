package com.hans.bet.soccer_service.match.infra.client.rest.dto.response;

public record GetMatchResponse (
        String uuid,
        String local,
        String visiting,
        String tournament,
        String status
) { }
