package com.aye.web.repository;

import com.aye.web.model.Team;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface TeamRepository extends MongoRepository<Team, Long> {
    Optional<Team> findByName(String name);
}
