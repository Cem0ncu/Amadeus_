package com.example.amadeus.mappers;

import com.example.amadeus.dto.FlightDTO;
import com.example.amadeus.entities.Flight;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;
@Mapper(componentModel = "spring")
public interface FlightMapper {

    Flight toFlight(FlightDTO airportDTO);

    FlightDTO toFlightDTO(Flight airport);

    List<FlightDTO> toFlightDTOs(List<Flight> airports);

    void updateFlight(@MappingTarget Flight target, Flight source);
}