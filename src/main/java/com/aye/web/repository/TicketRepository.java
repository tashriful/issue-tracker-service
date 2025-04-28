package com.aye.web.repository;

import com.aye.web.model.Department;
import com.aye.web.model.Employee;
import com.aye.web.model.Team;
import com.aye.web.model.Ticket;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends MongoRepository<Ticket, Long> {
    List<Ticket> findByDepartment(Long id);

    List<Ticket> findByAssignedTo(Employee assignedTo);

    List<Ticket> findByTeam(Long id);

    List<Ticket> findTicketByCreatedBy(Employee employee);

    Boolean existsByDepartment(Department department);

    Boolean existsByTeam(Team team);

    Boolean existsByAssignedTo(Employee employee);

    Boolean existsByAssignedBy(Employee employee);

    Boolean existsByCreatedBy(Employee employee);
}
