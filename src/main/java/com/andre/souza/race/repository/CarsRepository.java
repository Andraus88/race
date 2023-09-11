package com.andre.souza.race.repository;

import com.andre.souza.race.entity.Cars;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CarsRepository extends MongoRepository<Cars, Long> {
}
