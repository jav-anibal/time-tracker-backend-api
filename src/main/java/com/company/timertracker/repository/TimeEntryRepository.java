package com.company.timertracker.repository;

import com.company.timertracker.model.TimeEntry;
import com.company.timertracker.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

public interface TimeEntryRepository extends JpaRepository<TimeEntry, Long> {

    List<TimeEntry> findByUserOrderByTimestampDesc(User user);

    Optional<TimeEntry> findFirstByUserOrderByTimestampDesc(User user);

    List<TimeEntry> findByUserAndTimestampBetweenOrderByTimestampAsc(
            User user, Instant from, Instant to);

    long countByUser(User user);
}