package com.company.timertracker.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;

@Entity
@Table(
        name = "workdays",
        uniqueConstraints = @UniqueConstraint(columnNames = {"user_id", "work_date"})
)
@Getter
@Setter
@NoArgsConstructor
public class Workday {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "work_date", nullable = false)
    private LocalDate date;

    @Column(name = "start_time")
    private Instant startTime;

    @Column(name = "end_time")
    private Instant endTime;

    @Column(name = "total_minutes")
    private Long totalMinutes;

    public void close(Instant endTime) {
        this.endTime = endTime;
        if (startTime != null && endTime != null) {
            this.totalMinutes = Duration.between(startTime, endTime).toMinutes();
        }
    }
}