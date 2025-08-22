package com.hans.bet.soccer_service.match.infrastructure.persistence.mapper;

import com.hans.bet.soccer_service.match.domain.model.entity.Match;
import com.hans.bet.soccer_service.match.domain.model.valueobject.MatchId;
import com.hans.bet.soccer_service.match.domain.model.valueobject.Team;
import com.hans.bet.soccer_service.match.infrastructure.persistence.entity.MatchEntity;

public class MatchJPAMapper {

    public static Match toDomain (MatchEntity entity) {
        return Match.Builder
                .aMatch()
                .id(new MatchId(entity.getId()))
                .statusMatch(StatusMatchJpaMapper.toDomain(entity.getStatus()))
                .tournament(entity.getTournament())
                .local(new Team(entity.getLocal(), entity.getTournament()))
                .visiting(new Team(entity.getVisiting(), entity.getTournament()))
                .build();
    }

    public static MatchEntity toEntity (Match domain) {
        MatchEntity entity = new MatchEntity();

        entity.setId(domain.getId().getValue());
        entity.setLocal(domain.getLocal().name());
        entity.setVisiting(domain.getVisiting().name());
        entity.setTournament(domain.getTournament());
        entity.setStatus(StatusMatchJpaMapper.toEntity(domain.getStatusMatch()));

        System.out.println(entity);

        return entity;
    }

}
