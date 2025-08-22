package com.hans.bet.soccer_service.match.application.port.in;

import com.hans.bet.soccer_service.match.application.command.ScheduleMatchCommand;

public interface ScheduleMatchUseCase {
    String execute(ScheduleMatchCommand command);
}
