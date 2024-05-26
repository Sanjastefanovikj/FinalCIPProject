package com.example.demo.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;


import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    public Optional<Event> getEventById(Long event_id) {
        return eventRepository.findById(event_id);
    }

    public Event createEvent(Event event) {
        return eventRepository.save(event);
    }

    public Event updateEvent(Long event_id, Event eventDetails) {
        Optional<Event> eventOptional = eventRepository.findById(event_id);
        if (eventOptional.isPresent()) {
            Event event = eventOptional.get();
            event.setName(eventDetails.getName());
            event.setVenue(eventDetails.getVenue());
            event.setTime(eventDetails.getTime());
            event.setDate(eventDetails.getDate());
            return eventRepository.save(event);
        } else {
            return null; // or throw an exception or return an Optional
        }
    }

    public void deleteEvent(Long event_id) {
        eventRepository.deleteById(event_id);
    }

    public Event saveEvent(@RequestBody Event event) {
        return eventRepository.save(event);
    }

}
