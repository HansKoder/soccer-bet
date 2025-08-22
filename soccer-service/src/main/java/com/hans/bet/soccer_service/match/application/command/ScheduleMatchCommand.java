package com.hans.bet.soccer_service.match.application.command;

public record ScheduleMatchCommand(
        String local, String visiting, String tournament
) { }
