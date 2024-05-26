package com.example.demo.venue;

import com.example.demo.event.Event;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table
public class Venue {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE)
    private Long venue_id;

    private String name;
    private String location;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;

    public Venue(Long venue_id, String name, String location, Event event) {
        this.venue_id = venue_id;
        this.name = name;
        this.location = location;

    }

    public Venue(String name, String location, Event event) {
        this.name = name;
        this.location = location;

    }

    public Venue() {

    }

    public Long getVenue_id() {
        return venue_id;
    }

    public void setVenue_id(Long id) {
        this.venue_id = venue_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Venue{" +
                "id=" + venue_id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}


