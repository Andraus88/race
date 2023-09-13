package com.andre.souza.race.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarsDtoResponse {

    private Long carsId;

    private String brand;

    private String model;

    private String pilot;

    private Long year;

}
