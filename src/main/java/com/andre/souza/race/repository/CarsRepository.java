package com.andre.souza.race.repository;

import com.andre.souza.race.entity.Cars;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CarsRepository extends JpaRepository<Cars, Long> {
}
