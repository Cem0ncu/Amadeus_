package com.example.amadeus.services;

import com.example.amadeus.dto.AirportDTO;
import com.example.amadeus.entities.Airport;
import com.example.amadeus.exceptions.AppException;
import com.example.amadeus.mappers.AirportMapper;
import com.example.amadeus.repositories.AirportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AirportService {
    private final AirportRepository airportRepository;
    private final AirportMapper airportMapper;

    public List<AirportDTO> allAirports() {
        return airportMapper.toAirportDTOs(airportRepository.findAll());
    }

    public AirportDTO createAirport(AirportDTO airportDTO) {
        Airport airport = airportMapper.toAirport(airportDTO);

        Airport savedAirport = airportRepository.save(airport);

        return airportMapper.toAirportDTO(savedAirport);
    }

    public AirportDTO updateAirport(Long id, AirportDTO airportDTO) {
        Airport airport = airportRepository.findById(id)
                .orElseThrow(() -> new AppException("Airport not found", HttpStatus.NOT_FOUND));

        airportMapper.updateAirport(airport, airportMapper.toAirport(airportDTO));

        Airport savedAirport = airportRepository.save(airport);

        return airportMapper.toAirportDTO(savedAirport);
    }

    public AirportDTO patchAirport(Long id, AirportDTO airportDTO) {
        Airport airport = airportRepository.findById(id)
                .orElseThrow(() -> new AppException("Airport not found", HttpStatus.NOT_FOUND));

        if (airportDTO.getCity() != null) {
            airport.setCity(airportDTO.getCity());
        }

        Airport savedAirport = airportRepository.save(airport);

        return airportMapper.toAirportDTO(savedAirport);
    }

    public AirportDTO deleteAirport(Long id) {
        Airport airport = airportRepository.findById(id)
                .orElseThrow(() -> new AppException("Airport not found", HttpStatus.NOT_FOUND));
        AirportDTO airportDTO = airportMapper.toAirportDTO(airport);

        airportRepository.deleteById(id);

        return airportDTO;
    }

    public AirportDTO getAirport(Long id) {
        Airport airport = airportRepository.findById(id)
                .orElseThrow(() -> new AppException("Airport not found", HttpStatus.NOT_FOUND));
        return airportMapper.toAirportDTO(airport);
    }
}