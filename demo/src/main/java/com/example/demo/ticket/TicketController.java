package com.example.demo.ticket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/1/ticket")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @GetMapping
    public List<Ticket> getAllTickets() {
        return ticketService.getAllTickets();
    }

    @GetMapping("/{ticket_id}")
    public ResponseEntity<Ticket> getTicketById(@PathVariable Long ticket_id) {
        Optional<Ticket> ticket = ticketService.getTicketById(ticket_id);
        return ticket.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Ticket createTicket(@RequestBody Ticket ticket) {
        return ticketService.createTicket(ticket);
    }

    @PutMapping("/{ticket_id}")
    public ResponseEntity<Ticket> updateTicket(@PathVariable Long ticket_id, @RequestBody Ticket ticketDetails) {
        Ticket updatedTicket = ticketService.updateTicket(ticket_id, ticketDetails);
        if (updatedTicket != null) {
            return ResponseEntity.ok(updatedTicket);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{ticket_id}")
    public ResponseEntity<Void> deleteTicket(@PathVariable Long ticket_id) {
        ticketService.deleteTicket(ticket_id);
        return ResponseEntity.noContent().build();
    }
}
