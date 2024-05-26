package com.example.demo.ticket;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.example.demo.attendee.Attendee;
import com.example.demo.event.Event;
import jakarta.persistence.*;


@Entity
@Table
public class Ticket {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY)
    private Long ticket_id;

    private BigDecimal price;
    private String seatNumber;
    private LocalDateTime purchaseDate;
    private String status;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;


    @ManyToOne
    @JoinColumn(name="attendee_id")
    private Attendee attendee;



    public Ticket (Long ticket_id,Attendee attendee, Event event, LocalDateTime purchaseDate, String seatNumber, BigDecimal price, String status) {
        this.attendee = attendee;
        this.ticket_id = ticket_id;
        this.event = event;
        this.purchaseDate = purchaseDate;
        this.seatNumber = seatNumber;
        this.price = price;
        this.status = status;
    }

    public Ticket(Attendee attendee, Event event, LocalDateTime purchaseDate, String seatNumber, BigDecimal price, String status) {
        this.attendee = attendee;
        this.event = event;
        this.purchaseDate = purchaseDate;
        this.seatNumber = seatNumber;
        this.price = price;
        this.status = status;
    }

    public Ticket() {

    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public Long getTicketById() {
        return ticket_id;
    }

    public void setTicketById(Long userId) {
    }

    public LocalDateTime getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDateTime purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + ticket_id +
                ", event=" + event +
                ", purchaseDate=" + purchaseDate +
                ", seatNumber='" + seatNumber + '\'' +
                ", price=" + price +
                ", status='" + status + '\'' +
                '}';

    }

    public Attendee getAttendee() {
        return attendee;
    }

    public void setAttendee(Attendee attendee) {
        this.attendee = attendee;
    }
}
