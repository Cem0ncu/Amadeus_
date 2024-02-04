package com.example.amadeus.dto;

import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Getter
@Setter
public class AirportDTO {
    private Long id;

    @NotNull
    private String city;
}
