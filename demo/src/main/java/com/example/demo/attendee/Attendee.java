package com.example.demo.attendee;

import com.example.demo.ticket.Ticket;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Attendee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long attendee_id;

    private String name;
    private String email;

    @OneToMany(mappedBy = "attendee")
    private List<Ticket> tickets;

    public Attendee() {
    }

    public Attendee(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public Long getAttendee_id() {return attendee_id;}
    public void setAttendee_id(Long attendee_id) {this.attendee_id = attendee_id;}

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}
}