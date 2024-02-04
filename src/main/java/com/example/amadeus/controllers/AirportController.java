package com.example.amadeus.controllers;

import com.example.amadeus.dto.AirportDTO;
import com.example.amadeus.services.AirportService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class AirportController {
    private final AirportService airportService;

    @GetMapping("/airports")
    public ResponseEntity<List<AirportDTO>> allAirports() {
        return ResponseEntity.ok(airportService.allAirports());
    }

    @PostMapping("/airports")
    public ResponseEntity<AirportDTO> createAirport(@Valid @RequestBody AirportDTO airportDTO) {
        AirportDTO createdAirport = airportService.createAirport(airportDTO);
        return ResponseEntity.created(URI.create("/airports/" + airportDTO.getId())).body(createdAirport);
    }

    @GetMapping("/airports/{id}")
    public ResponseEntity<AirportDTO> getAirport(@PathVariable Long id) {
        return ResponseEntity.ok(airportService.getAirport(id));
    }

    @PutMapping("/airports/{id}")
    public ResponseEntity<AirportDTO> updateAirport(@PathVariable Long id, @Valid @RequestBody AirportDTO airportDTO) {
        return ResponseEntity.ok(airportService.updateAirport(id, airportDTO));
    }

    @PatchMapping("/airports/{id}")
    public ResponseEntity<AirportDTO> patchAirport(@PathVariable Long id, @RequestBody AirportDTO airportDTO) {
        return ResponseEntity.ok(airportService.patchAirport(id, airportDTO));
    }

    @DeleteMapping("/airports/{id}")
    public ResponseEntity<AirportDTO> deleteAirport(@PathVariable Long id) {
        return ResponseEntity.ok(airportService.deleteAirport(id));
    }
}
