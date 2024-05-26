package com.example.demo.attendee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="api/1/attendee")
public class AttendeeController {

    @Autowired
    private AttendeeService attendeeService;

    @GetMapping
    public List<Attendee> getAllAttendees() {
        return attendeeService.getAllAttendees();
    }

    @GetMapping("/{attendee_id}")
    public Attendee getAttendeeById(@PathVariable Long attendee_id) {
        return attendeeService.getAttendeeById(attendee_id);
    }


    @PutMapping("/{attendee_id}")
    public Attendee updateAttendee(@PathVariable Long attendee_id, @RequestBody Attendee attendee) {
        return attendeeService.updateAttendee(attendee_id, attendee);

    }
        @DeleteMapping("/{attendee_id}")
        public void deleteAttendee (@PathVariable Long attendee_id){
            attendeeService.deleteAttendee(attendee_id);

        }

        @PostMapping
        public Attendee saveAttendee(@RequestBody Attendee attendee) {
            return attendeeService.createAttendee(attendee);
        }

    }


