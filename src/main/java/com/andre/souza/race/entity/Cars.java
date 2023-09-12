package com.andre.souza.race.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "db_ms-cars")
@Builder
        public class Cars {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(nullable = false, unique = true)
    private String brand;
    @Column(nullable = false, unique = true)
    private String model;
    @Column(nullable = false, unique = true)
    private String pilot;
    @Column(nullable = false)
    private Long year;

}
