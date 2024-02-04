package com.example.amadeus.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Getter
@Setter
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @JoinColumn(name="departed_air_port_id", nullable=false)
    private Long departedAirport;

    @JoinColumn(name="destination_air_port_id", nullable=false)
    private Long destinationAirport;

    @Column
    private LocalDateTime departureDateTime;
    @Column
    private LocalDateTime arrivalDateTime;
}
