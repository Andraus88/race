package com.andre.souza.race.cars.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cars")
@Builder
        public class Cars implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private String CarsId;
    @Column(nullable = false, unique = true)
    private String brand;
    @Column(nullable = false, unique = true)
    private String model;
    @Column(nullable = false, unique = true)
    private String pilot;
    @Column(nullable = false)
    private Long year;

}
