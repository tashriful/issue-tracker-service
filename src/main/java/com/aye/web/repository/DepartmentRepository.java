package com.aye.web.repository;

import com.aye.web.model.Department;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface DepartmentRepository extends MongoRepository<Department, Long> {

    Optional<Department> findByName (String name);
}
