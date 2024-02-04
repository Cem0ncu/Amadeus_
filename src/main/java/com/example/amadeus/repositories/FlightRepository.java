package com.example.amadeus.repositories;

import com.example.amadeus.entities.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
public interface FlightRepository extends JpaRepository<Flight, Long> {
}