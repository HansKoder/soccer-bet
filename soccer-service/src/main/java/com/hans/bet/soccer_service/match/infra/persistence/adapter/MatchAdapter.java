package com.hans.bet.soccer_service.match.infra.persistence.adapter;

import com.hans.bet.soccer_service.match.application.port.out.MatchRepository;
import com.hans.bet.soccer_service.match.domain.model.entity.Match;
import com.hans.bet.soccer_service.match.infra.persistence.mapper.MatchJPAMapper;
import com.hans.bet.soccer_service.match.infra.persistence.springdata.MatchSpringData;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public class MatchAdapter implements MatchRepository {

    private final MatchSpringData repository;

    public MatchAdapter(MatchSpringData repository) {
        this.repository = repository;
    }

    @Override
    public void save(Match domain) {
        repository.save(MatchJPAMapper.toEntity(domain));
    }

    @Override
    public Optional<Match> get(UUID uuid) {
        return repository.findById(uuid).map(MatchJPAMapper::toDomain);
    }

}
