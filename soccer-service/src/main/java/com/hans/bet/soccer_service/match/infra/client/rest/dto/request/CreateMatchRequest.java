package com.hans.bet.soccer_service.match.infra.client.rest.dto.request;

public record CreateMatchRequest (
        String local, String visiting, String tournament
) {}
