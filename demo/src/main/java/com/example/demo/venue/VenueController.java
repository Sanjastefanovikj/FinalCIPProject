package com.example.demo.venue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(path="api/1/venue")
public class VenueController {

    @Autowired
    private VenueService venueService;

    @GetMapping
    public List<Venue> getAllVenues() {
        return venueService.getAllVenues();
    }

    @GetMapping("/{venue_id}")
    public ResponseEntity<Venue> getVenueById(@PathVariable Long venue_id) {
        try {
            Venue venue = venueService.getVenueById(venue_id)
                    .orElseThrow(() -> new Exception("Venue not found")); // or use a more specific exception
            return ResponseEntity.ok(venue);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Venue createVenue(@RequestBody Venue venue) {
        return venueService.createVenue(venue);
    }

    @PutMapping("/{venue_id}")
    public ResponseEntity<Venue> updateVenue(@PathVariable Long venue_id, @RequestBody Venue venueDetails) {
        Venue updatedVenue = venueService.updateVenue(venue_id, venueDetails);
        if (updatedVenue != null) {
            return ResponseEntity.ok(updatedVenue);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{venue_id}")
    public ResponseEntity<Void> deleteVenue(@PathVariable Long venue_id) {
        venueService.deleteVenue(venue_id);
        return ResponseEntity.noContent().build();
    }
}
