package com.aye.web.repository;

import com.aye.web.model.Department;
import com.aye.web.model.DepartmentHead;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface DepartmentHeadRepository extends MongoRepository<DepartmentHead, Long> {
    List<DepartmentHead> findByDepartment(Department department);
}
