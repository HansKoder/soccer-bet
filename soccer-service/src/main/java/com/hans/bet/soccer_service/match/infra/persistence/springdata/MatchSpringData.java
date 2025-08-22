package com.hans.bet.soccer_service.match.infra.persistence.springdata;

import com.hans.bet.soccer_service.match.infra.persistence.entity.MatchEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface MatchSpringData extends CrudRepository<MatchEntity, UUID> {
}
