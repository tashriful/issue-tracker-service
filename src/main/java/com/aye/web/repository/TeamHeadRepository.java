package com.aye.web.repository;

import com.aye.web.model.TeamHead;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TeamHeadRepository extends MongoRepository<TeamHead, Long> {
}
