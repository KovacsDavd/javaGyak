package com.epam.training.ticketservice.core.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.time.LocalDateTime;

@Entity
@Table(name = "Screening")
public class Screening {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String room;
    private LocalDateTime time;

    public Screening(String title, String room, LocalDateTime time) {
        this.title = title;
        this.room = room;
        this.time = time;
    }

    public Screening() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getroom() {
        return room;
    }

    public void setroom(String room) {
        this.room = room;
    }

    public LocalDateTime getDateTime() {
        return time;
    }

    public void setDateTime(LocalDateTime time) {
        this.time = time;
    }
}
