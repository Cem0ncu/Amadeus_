package com.example.amadeus.services;

import com.example.amadeus.dto.FlightDTO;
import com.example.amadeus.entities.Flight;
import com.example.amadeus.exceptions.AppException;
import com.example.amadeus.mappers.FlightMapper;
import com.example.amadeus.repositories.FlightRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FlightService {
    private final FlightRepository flightRepository;
    private final FlightMapper flightMapper;

    public List<FlightDTO> allFlights() {
        return flightMapper.toFlightDTOs(flightRepository.findAll());
    }

    public FlightDTO createFlight(FlightDTO flightDTO) {
        Flight flight = flightMapper.toFlight(flightDTO);

        Flight savedFlight = flightRepository.save(flight);

        return flightMapper.toFlightDTO(savedFlight);
    }

    public FlightDTO updateFlight(Long id, FlightDTO flightDTO) {
        Flight flight = flightRepository.findById(id)
                .orElseThrow(() -> new AppException("Flight not found", HttpStatus.NOT_FOUND));

        flightMapper.updateFlight(flight, flightMapper.toFlight(flightDTO));

        Flight savedFlight = flightRepository.save(flight);

        return flightMapper.toFlightDTO(savedFlight);
    }

    public FlightDTO patchFlight(Long id, FlightDTO flightDTO) {
        Flight flight = flightRepository.findById(id)
                .orElseThrow(() -> new AppException("Flight not found", HttpStatus.NOT_FOUND));

        if (flightDTO.getArrivalDateTime() != null) {
            flight.setArrivalDateTime(flightDTO.getArrivalDateTime());
        }
        if (flightDTO.getDepartureDateTime() != null) {
            flight.setDepartureDateTime(flightDTO.getDepartureDateTime());
        }
        if (flightDTO.getDepartedAirport() != null) {
            flight.setDepartedAirport(flightDTO.getDepartedAirport());
        }
        if (flightDTO.getDestionationAirport() != null) {
            flight.setDestinationAirport(flightDTO.getDestionationAirport());
        }

        Flight savedFlight = flightRepository.save(flight);

        return flightMapper.toFlightDTO(savedFlight);
    }

    public FlightDTO deleteFlight(Long id) {
        Flight flight = flightRepository.findById(id)
                .orElseThrow(() -> new AppException("Flight not found", HttpStatus.NOT_FOUND));
        FlightDTO flightDTO = flightMapper.toFlightDTO(flight);

        flightRepository.deleteById(id);

        return flightDTO;
    }

    public FlightDTO getFlight(Long id) {
        Flight flight = flightRepository.findById(id)
                .orElseThrow(() -> new AppException("Flight not found", HttpStatus.NOT_FOUND));
        return flightMapper.toFlightDTO(flight);
    }
}