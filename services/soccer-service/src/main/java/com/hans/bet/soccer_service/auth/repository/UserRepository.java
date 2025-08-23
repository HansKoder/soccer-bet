package com.hans.bet.soccer_service.auth.repository;

import com.hans.bet.soccer_service.auth.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, String> {
}
