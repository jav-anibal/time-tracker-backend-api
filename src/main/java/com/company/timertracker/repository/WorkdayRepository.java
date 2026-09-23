package com.company.timertracker.repository;

import com.company.timertracker.model.User;
import com.company.timertracker.model.Workday;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface WorkdayRepository extends JpaRepository<Workday, Long> {
    Optional<Workday> findByUserAndDate(User user, LocalDate date);

    List<Workday> findByUserOrderByDateDesc(User user);
}