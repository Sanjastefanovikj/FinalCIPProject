package com.example.demo.attendee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttendeeService {

    @Autowired
    private AttendeeRepository attendeeRepository;

    public List<Attendee> getAllAttendees() {
        return (List<Attendee>) attendeeRepository.findAll();
    }

    public Attendee getAttendeeById(Long attendee_id) {
        return attendeeRepository.findById(attendee_id).orElse(null);
    }

    public Attendee createAttendee(Attendee attendee) {
        return attendeeRepository.save(attendee);
    }

    public Attendee updateAttendee(Long attendee_id, Attendee attendeeDetails) {
        if (attendeeRepository.existsById(attendee_id)) {
            attendeeDetails.setAttendee_id(attendee_id);
            return attendeeRepository.save(attendeeDetails);
        }
        return null;
    }
    public Attendee saveAttendee(Attendee attendee) {
        return attendeeRepository.save(attendee);
    }

    public void deleteAttendee(Long attendee_id) {
        attendeeRepository.deleteById(attendee_id);
    }
}
