package com.example.demo.event;

import com.example.demo.ticket.Ticket;
import com.example.demo.venue.Venue;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table
public class Event {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long event_id;



    private String name;
    private String venue;
    private Double time;
    private Date  date;


    @OneToMany(mappedBy = "event")
    private List<Ticket> tickets;

    @OneToMany(mappedBy = "event")
    private List<Venue> venueObject;


    public Event() {

    }

    public Long getEvent_id() {
        return event_id;
    }

    public void setEvent_id(Long event_id) {
        this.event_id = event_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public Double getTime() {
        return time;
    }

    public void setTime(Double time) {
        this.time = time;
    }

    public  Date getDate() {
        return date;
    }

    public void setDate( Date date) {
        this.date = date;
    }




}
