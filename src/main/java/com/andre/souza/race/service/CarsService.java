package com.andre.souza.race.service;

import com.andre.souza.race.dto.CarsDtoRequest;
import com.andre.souza.race.dto.CarsDtoResponse;
import com.andre.souza.race.entity.Cars;
import com.andre.souza.race.exception.NotAllowedException;
import com.andre.souza.race.exception.NotFoundException;
import com.andre.souza.race.repository.CarsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarsService {
    @Autowired
    CarsRepository carsRepository;

    public CarsDtoRequest save(CarsDtoRequest carsDtoRequest) throws NotAllowedException {
        Cars cars = new Cars();
        cars.setId(null);
        cars.setBrand(carsDtoRequest.getBrand());
        cars.setModel(carsDtoRequest.getModel());
        cars.setPilot(carsDtoRequest.getPilot());
        cars.setYear(carsDtoRequest.getYear());

        if (carsDtoRequest.getBrand() == null || carsDtoRequest.getModel() == null || carsDtoRequest.getPilot() == null || carsDtoRequest.getYear() == null) {
            throw new NotAllowedException("The Brand, Model, Pilot and Year must not be null");
        }

        carsRepository.save(cars);

        return carsDtoRequest;
    }

    public CarsDtoResponse getByID(Long id) {
        Cars cars =
                carsRepository.findById(id).orElseThrow(() -> new NotFoundException("Id Not Found"));

        CarsDtoResponse carsDtoResponse = new CarsDtoResponse(
                cars.getId(),
                cars.getBrand(),
                cars.getModel(),
                cars.getPilot(),
                cars.getYear()
        );
        return carsDtoResponse;
    }

    public List<CarsDtoResponse> getAllCars() {
        List<Cars> cars = carsRepository.findAll();
        List<CarsDtoResponse> carDtoResponses = new ArrayList<>();
        for (Cars car : cars) {
            CarsDtoResponse carsDtoResponse = new CarsDtoResponse(
                    car.getId(),
                    car.getBrand(),
                    car.getModel(),
                    car.getPilot(),
                    car.getYear()
            );
            carDtoResponses.add(carsDtoResponse);
        }
        return carDtoResponses;
    }

    public CarsDtoRequest delete(Long id) throws NotFoundException {

        Cars cars = carsRepository.findById(id).orElseThrow(() -> new NotFoundException("Car with id " + id + " not found"));

        carsRepository.delete(cars);

        return new CarsDtoRequest();
    }

    public CarsDtoRequest updateCar(@PathVariable("id") Long id, @RequestBody CarsDtoRequest carsDtoRequest) throws NotFoundException {

        Cars cars = carsRepository.findById(id).orElseThrow(() -> new NotFoundException("Car with id " + id + " not found"));

        cars.setBrand(carsDtoRequest.getBrand());
        cars.setModel(carsDtoRequest.getModel());
        cars.setPilot(carsDtoRequest.getPilot());
        cars.setYear(carsDtoRequest.getYear());

        carsRepository.save(cars);

        return carsDtoRequest;
    }

}

