package com.example.demo.venue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VenueService {

    @Autowired
    private VenueRepository venueRepository;

    public List<Venue> getAllVenues() {
        return (List<Venue>) venueRepository.findAll();
    }

    public Optional<Venue> getVenueById(Long venue_id) {
        return venueRepository.findById(venue_id);
    }

    public Venue createVenue(Venue venue) {
        return venueRepository.save(venue);
    }

    public Venue updateVenue(Long venue_id, Venue venueDetails) {
        Optional<Venue> venueOptional = venueRepository.findById(venue_id);
        if (venueOptional.isPresent()) {
            Venue venue = venueOptional.get();
            venue.setName(venueDetails.getName());
            venue.setLocation(venueDetails.getLocation());
            return venueRepository.save(venue);
        } else {
            return null; // or throw an exception or return an Optional
        }
    }

    public void deleteVenue(Long venue_id) {
        venueRepository.deleteById(venue_id);
    }
}
