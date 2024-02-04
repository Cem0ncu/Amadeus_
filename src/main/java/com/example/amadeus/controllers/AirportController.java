package com.example.amadeus.controllers;

import com.example.amadeus.dto.AirportDTO;
import com.example.amadeus.services.AirportService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
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
    @Tag(name = "get", description = "GET method for list of All Airports")
    @Operation(summary = "Get all Airports",
            description = "returns list of all airports in database")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(mediaType = "application/json",
                    schema = @Schema(implementation = AirportDTO.class)) })
    })
    @GetMapping("/airports")
    public ResponseEntity<List<AirportDTO>> allAirports() {
        return ResponseEntity.ok(airportService.allAirports());
    }

    @PostMapping("/airports")
    public ResponseEntity<AirportDTO> createAirport(@Parameter(
            description = "Data Transfer Object of Airport",
            required = true)
            @Valid @RequestBody AirportDTO airportDTO) {
        AirportDTO createdAirport = airportService.createAirport(airportDTO);
        return ResponseEntity.created(URI.create("/airports/" + airportDTO.getId())).body(createdAirport);
    }

    @GetMapping("/airports/{id}")
    public ResponseEntity<AirportDTO> getAirport(@Parameter(
            description = "Id of Airport",
            required = true) @PathVariable Long id) {
        return ResponseEntity.ok(airportService.getAirport(id));
    }

    @PutMapping("/airports/{id}")
    public ResponseEntity<AirportDTO> updateAirport(@Parameter(
            description = "Id of Airport",
            required = true)@PathVariable Long id, @Parameter(
            description = "Data Transfer Object of Airport",
            required = true) @Valid @RequestBody AirportDTO airportDTO) {
        return ResponseEntity.ok(airportService.updateAirport(id, airportDTO));
    }

    @PatchMapping("/airports/{id}")
    public ResponseEntity<AirportDTO> patchAirport(@Parameter(
            description = "Id of Airport",
            required = true) @PathVariable Long id, @Parameter(
            description = "Data Transfer Object of Airport",
            required = true)@RequestBody AirportDTO airportDTO) {
        return ResponseEntity.ok(airportService.patchAirport(id, airportDTO));
    }

    @DeleteMapping("/airports/{id}")
    public ResponseEntity<AirportDTO> deleteAirport(@Parameter(
            description = "Id of Airport",
            required = true) @PathVariable Long id) {
        return ResponseEntity.ok(airportService.deleteAirport(id));
    }
}
