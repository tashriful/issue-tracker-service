package com.aye.web.repository;

import com.aye.web.model.Department;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProjectRepository extends MongoRepository<Department, Long> {
}
