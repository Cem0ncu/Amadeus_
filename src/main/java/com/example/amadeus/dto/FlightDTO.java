package com.example.amadeus.dto;

import com.example.amadeus.entities.Airport;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Getter
@Setter
public class FlightDTO {
    private Long id;
    @NotNull
    private Airport departedAirport;
    @NotNull
    private Airport destionationAirport;
    @NotNull
    private LocalDateTime departureDateTime;
    @NotNull
    private LocalDateTime arrivalDateTime;
}
