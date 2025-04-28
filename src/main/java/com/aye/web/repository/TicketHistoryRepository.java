package com.aye.web.repository;

import com.aye.web.model.Employee;
import  com.aye.web.model.Ticket;
import com.aye.web.model.TicketHistory;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TicketHistoryRepository extends MongoRepository<TicketHistory, Long> {

    TicketHistory findTicketHistoryByTicketAndAssignedToAndAssignedByAndEndDate
            (Ticket ticket, Employee assignedTo, Employee assignedBy, LocalDate endDate);

    List<TicketHistory> findTicketHistoryByTicket(Ticket ticket);
}
