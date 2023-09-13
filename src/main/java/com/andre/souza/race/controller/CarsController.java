package com.andre.souza.race.controller;

import com.andre.souza.race.dto.CarsDtoRequest;
import com.andre.souza.race.dto.CarsDtoResponse;
import com.andre.souza.race.exception.NotAllowedException;
import com.andre.souza.race.exception.NotFoundException;
import com.andre.souza.race.service.CarsService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping(value = "/cars")
public class CarsController {
    @Autowired
    CarsService carsService;

    @Autowired
    RabbitTemplate rabbitTemplate;

    @PostMapping("/post")
    public CarsDtoRequest saveCar(@RequestBody CarsDtoRequest carsDtoRequest) throws NotAllowedException {
        return carsService.save(carsDtoRequest);
    }
    @GetMapping("/get/{carsId}")
    public CarsDtoResponse get(@PathVariable String carsId) {
        return carsService.getByID(carsId);
    }

    @GetMapping("/getAll")
    public List<CarsDtoResponse> getAllCars() {
        return carsService.getAllCars();

    }

    @DeleteMapping("/delete/{carsId}")
    public CarsDtoRequest deleteCar(@PathVariable("carsId") String carsId) throws NotFoundException {
        return carsService.delete(carsId);
    }

    @PutMapping("/put/{carsId}")
    public CarsDtoRequest updateCar(@PathVariable("carsId") String carsId, @RequestBody CarsDtoRequest carsDtoRequest) throws NotFoundException {
        return carsService.updateCar(carsId, carsDtoRequest);
    }

}
