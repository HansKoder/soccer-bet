package com.hans.bet.soccer_service.match.infrastructure.persistence.springdata;

import com.hans.bet.soccer_service.match.infrastructure.persistence.entity.MatchEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface MatchSpringData extends CrudRepository<MatchEntity, UUID> {
}
