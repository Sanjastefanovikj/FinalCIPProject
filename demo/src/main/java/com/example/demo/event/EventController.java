package com.example.demo.event;

import com.example.demo.attendee.Attendee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/1/event")
public class EventController {

    @Autowired
    private EventService eventService;

    @GetMapping
    public List<Event> getAllEvents() {
        return eventService.getAllEvents();
    }

    @GetMapping("/{event_id}")
    public ResponseEntity<Optional<Event>> getEventById(@PathVariable Long event_id) {
        Optional<Event> event = eventService.getEventById(event_id);
        if (event.isPresent()) {
            return ResponseEntity.ok(event);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{event_id}")
    public ResponseEntity<Event> updateEvent(@PathVariable Long event_id, @RequestBody Event eventDetails) {
        Event updatedEvent = eventService.updateEvent(event_id, eventDetails);
        if (updatedEvent != null) {
            return ResponseEntity.ok(updatedEvent);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{event_id}")
    public ResponseEntity<Void> deleteEvent(@PathVariable Long event_id) {
        eventService.deleteEvent(event_id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public Event saveEvent(@RequestBody Event event) {
        return eventService.saveEvent(event);
    }
}
