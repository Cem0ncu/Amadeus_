package com.example.amadeus.repositories;

import com.example.amadeus.entities.Airport;
import org.springframework.data.jpa.repository.JpaRepository;
public interface AirportRepository extends JpaRepository<Airport, Long> {
}