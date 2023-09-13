package com.andre.souza.race.cars.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarsDtoResponse {

    private String carsId;

    private String brand;

    private String model;

    private String pilot;

    private Long year;

}
