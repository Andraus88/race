package com.andre.souza.race.cars.dto;

import lombok.Data;

import jakarta.validation.constraints.NotEmpty;

@Data
public class CarsDtoRequest {

    @NotEmpty(message = "Brand should not be null or empty and must be unique")
    private String brand;

    @NotEmpty(message = "Model should not be null or empty and must be unique")
    private String model;

    @NotEmpty(message = "Pilot should not be null or empty and must be unique")
    private String pilot;

    @NotEmpty(message = "Year should not be null or empty")
    private Long year;

}
