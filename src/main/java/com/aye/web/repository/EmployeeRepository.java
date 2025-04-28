package com.aye.web.repository;

import com.aye.web.model.Department;
import com.aye.web.model.Employee;
import com.aye.web.model.Team;
import com.aye.web.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, Long> {

//    List<Employee> findByUser(User user);

    Employee findByUser(User user);
    Employee findByTeamAndIsTeamHead(Team team, Boolean status);

    Employee findByDepartmentAndIsDeptHead(Department department, boolean isDeptHead);

    List<Employee> findEmployeesByDepartment(Department department);

    Optional<Employee> findEmployeeByUser(User user);

    Boolean existsByDepartment(Department department);

    Boolean existsByTeam(Team team);
}
