package com.hans.bet.soccer_service.match.infrastructure.persistence.mapper;

import com.hans.bet.soccer_service.match.domain.model.valueobject.StatusMatch;
import com.hans.bet.soccer_service.match.infrastructure.persistence.entity.StatusMatchJPA;

import java.util.Objects;

public class StatusMatchJpaMapper {

    public static StatusMatch toDomain (StatusMatchJPA entity) {
        if (Objects.isNull(entity)) return null;

        return StatusMatch.valueOf(entity.name());
    }

    public static StatusMatchJPA toEntity (StatusMatch domain) {
        if (Objects.isNull(domain)) return null;

        return StatusMatchJPA.valueOf(domain.name());
    }

}
