package com.andre.souza.race.controller;

import com.andre.souza.race.dto.CarsDtoRequest;
import com.andre.souza.race.dto.CarsDtoResponse;
import com.andre.souza.race.exception.NotAllowedException;
import com.andre.souza.race.exception.NotFoundException;
import com.andre.souza.race.service.CarsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;
@RestController
@RequestMapping(value = "/cars")
public class CarsController {
    @Autowired
    CarsService carsService;

    @PostMapping("/post")
    public CarsDtoRequest saveCar(@RequestBody CarsDtoRequest carsDtoRequest) throws NotAllowedException {
        return carsService.save(carsDtoRequest);
    }
    @GetMapping("/get/{id}")
    public CarsDtoResponse get(@PathVariable Long id) {
        return carsService.getByID(id);
    }

    @GetMapping("/getAll")
    public List<CarsDtoResponse> getAllCars() {
        return carsService.getAllCars();
    }

    @DeleteMapping("/delete/{id}")
    public CarsDtoRequest deleteCar(@PathVariable("id") Long id) throws NotFoundException {
        return carsService.delete(id);
    }

    @PutMapping("/put/{id}")
    public CarsDtoRequest updateCar(@PathVariable("id") Long id, @RequestBody CarsDtoRequest carsDtoRequest) throws NotFoundException {
        return carsService.updateCar(id, carsDtoRequest);
    }

}
