package com.hans.bet.soccer_service.match.application.usecase;

public interface PayloadSerializer {
    String toJson (Object event);
}
