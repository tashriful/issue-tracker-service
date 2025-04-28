package com.aye.web.repository;

import com.aye.web.model.Team;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProjectCorrdinatorRepository extends MongoRepository<Team, Long> {
}
