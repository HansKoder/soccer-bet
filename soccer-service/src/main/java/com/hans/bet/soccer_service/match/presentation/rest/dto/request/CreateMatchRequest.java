package com.hans.bet.soccer_service.match.presentation.rest.dto.request;

public record CreateMatchRequest (
        String local, String visiting, String tournament
) {}
