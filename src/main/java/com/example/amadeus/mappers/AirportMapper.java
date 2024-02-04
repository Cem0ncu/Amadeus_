package com.example.amadeus.mappers;

import com.example.amadeus.dto.AirportDTO;
import com.example.amadeus.entities.Airport;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Mapper(componentModel = "spring")
public interface AirportMapper {

    Airport toAirport(AirportDTO airportDTO);

    AirportDTO toAirportDTO(Airport airport);

    List<AirportDTO> toAirportDTOs(List<Airport> airports);

    void updateAirport(@MappingTarget Airport target, Airport source);
}