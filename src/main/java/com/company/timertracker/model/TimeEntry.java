package com.company.timertracker.model;

import com.company.timertracker.enums.TimeEntryType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Entity
@Table(name = "time_entries")
@Getter
@Setter
@NoArgsConstructor
public class TimeEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 16)
    private TimeEntryType type;

    @Column(nullable = false)
    private Instant timestamp;

    @Column(length = 255)
    private String notes;

    public TimeEntry(User user, TimeEntryType type, Instant timestamp) {
        this.user = user;
        this.type = type;
        this.timestamp = timestamp;
    }
}