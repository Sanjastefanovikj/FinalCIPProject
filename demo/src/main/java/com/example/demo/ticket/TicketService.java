package com.example.demo.ticket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    public Optional<Ticket> getTicketById(Long ticket_id) {
        return ticketRepository.findById(ticket_id);
    }

    public Ticket createTicket(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    public Ticket updateTicket(Long ticket_id, Ticket ticketDetails) {
        Optional<Ticket> ticketOptional = ticketRepository.findById(ticket_id);
        if (ticketOptional.isPresent()) {
            Ticket ticket = ticketOptional.get();
            ticket.setAttendee(ticketDetails.getAttendee());
            ticket.setEvent(ticketDetails.getEvent());
            ticket.setPurchaseDate(ticketDetails.getPurchaseDate());
            ticket.setSeatNumber(ticketDetails.getSeatNumber());
            ticket.setPrice(ticketDetails.getPrice());
            ticket.setStatus(ticketDetails.getStatus());
            return ticketRepository.save(ticket);
        } else {
            return null;
        }
    }

    public void deleteTicket(Long ticket_id) {
        ticketRepository.deleteById(ticket_id);
    }

}
