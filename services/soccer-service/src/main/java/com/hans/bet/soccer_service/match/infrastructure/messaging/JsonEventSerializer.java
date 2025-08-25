package com.hans.bet.soccer_service.match.infrastructure.messaging;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.hans.bet.soccer_service.match.application.usecase.PayloadSerializer;
import org.springframework.stereotype.Component;

@Component
public class JsonEventSerializer implements PayloadSerializer {

    private final ObjectMapper objectMapper;

    public JsonEventSerializer() {
        this.objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    }

    @Override
    public String toJson(Object event) {
        try {
            return objectMapper.writeValueAsString(event);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
