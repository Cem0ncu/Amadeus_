package com.example.amadeus.controllers;

import com.example.amadeus.dto.FlightDTO;
import com.example.amadeus.services.FlightService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class FlightController {
    private final FlightService flightService;

    @GetMapping("/flights")
    public ResponseEntity<List<FlightDTO>> allFlights() {
        return ResponseEntity.ok(flightService.allFlights());
    }

    @PostMapping("/flights")
    public ResponseEntity<FlightDTO> createFlight(@Valid @RequestBody FlightDTO flightDTO) {
        FlightDTO createdFlight = flightService.createFlight(flightDTO);
        return ResponseEntity.created(URI.create("/flights/" + flightDTO.getId())).body(createdFlight);
    }

    @GetMapping("/flights/{id}")
    public ResponseEntity<FlightDTO> getFlight(@PathVariable Long id) {
        return ResponseEntity.ok(flightService.getFlight(id));
    }

    @PutMapping("/flights/{id}")
    public ResponseEntity<FlightDTO> updateFlight(@PathVariable Long id, @Valid @RequestBody FlightDTO flightDTO) {
        return ResponseEntity.ok(flightService.updateFlight(id, flightDTO));
    }

    @PatchMapping("/flights/{id}")
    public ResponseEntity<FlightDTO> patchFlight(@PathVariable Long id, @RequestBody FlightDTO flightDTO) {
        return ResponseEntity.ok(flightService.patchFlight(id, flightDTO));
    }

    @DeleteMapping("/flights/{id}")
    public ResponseEntity<FlightDTO> deleteFlight(@PathVariable Long id) {
        return ResponseEntity.ok(flightService.deleteFlight(id));
    }
}
