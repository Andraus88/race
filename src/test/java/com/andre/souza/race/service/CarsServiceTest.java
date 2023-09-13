package com.andre.souza.race.service;

import com.andre.souza.race.dto.CarsDtoRequest;
import com.andre.souza.race.dto.CarsDtoResponse;
import com.andre.souza.race.entity.Cars;
import com.andre.souza.race.exception.NotFoundException;
import com.andre.souza.race.repository.CarsRepository;
import com.andre.souza.race.utils.JsonUtils;
import lombok.SneakyThrows;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CarsServiceTest {

    @InjectMocks
    private CarsService carsService;

    @Mock
    private CarsRepository carsRepository;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    private static final String CARS = "Cars.json";


    @SneakyThrows
    @Test
        void save(){
        //given
        CarsDtoRequest carsDtoRequest = JsonUtils.getObjectFromFile(CARS, CarsDtoRequest.class);

        when(carsRepository.save(any())).thenReturn(Cars.builder().brand(carsDtoRequest.getBrand()).build());
        when(carsRepository.save(any())).thenReturn(Cars.builder().model(carsDtoRequest.getModel()).build());
        when(carsRepository.save(any())).thenReturn(Cars.builder().pilot(carsDtoRequest.getPilot()).build());
        when(carsRepository.save(any())).thenReturn(Cars.builder().year(carsDtoRequest.getYear()).build());

        //when
        CarsDtoRequest savedCarsDtoRequest = carsService.save(carsDtoRequest);

        //then
        assertEquals(carsDtoRequest.getBrand(), savedCarsDtoRequest.getBrand());
        assertEquals(carsDtoRequest.getModel(), savedCarsDtoRequest.getModel());
        assertEquals(carsDtoRequest.getPilot(), savedCarsDtoRequest.getPilot());
        assertEquals(carsDtoRequest.getYear(), savedCarsDtoRequest.getYear());

        //verify
        Mockito.verify(carsRepository).save(any(Cars.class));
    }

    @SneakyThrows
    @Test
    void getByID() throws NotFoundException {

        //given
        String carsId = "1";
        Cars car = new Cars();
        car.setBrand("Honda");
        car.setModel("Civic");
        car.setPilot("Pedro");
        car.setYear(2020L);

        when(carsRepository.findById(carsId)).thenReturn(Optional.of(car));

        //when
        CarsDtoResponse carsDtoResponse = carsService.getByID(carsId);

        //then
        assertEquals(car.getCarsId(), carsDtoResponse.getCarsId());
        assertEquals(car.getBrand(), carsDtoResponse.getBrand());
        assertEquals(car.getModel(), carsDtoResponse.getModel());
        assertEquals(car.getPilot(), carsDtoResponse.getPilot());
        assertEquals(car.getYear(), carsDtoResponse.getYear());

        //verify
        Mockito.verify(carsRepository).findById(carsId);
    }

    @Test
    void getAllCars() {
        //given
        List<Cars> cars = new ArrayList<>();
        Cars car1 = new Cars();
        car1.setBrand("Honda");
        car1.setModel("Civic");
        car1.setPilot("Pedro");
        car1.setYear(2023L);

        Cars car2 = new Cars();
        car2.setBrand("Toyota");
        car2.setModel("Corolla");
        car2.setPilot("Jorge");
        car2.setYear(2022L );

        cars.add(car1);
        cars.add(car2);

        when(carsRepository.findAll()).thenReturn(cars);

        //when
        List<CarsDtoResponse> carsDtoResponses = carsService.getAllCars();

        //then
        assertEquals(2, carsDtoResponses.size());

        //verify
        Mockito.verify(carsRepository).findAll();
    }

    @SneakyThrows
    @Test
    void delete() {
        //given
        String carsId = "1";

        Cars car = new Cars();
        car.setBrand("Honda");
        car.setModel("Civic");
        car.setPilot("Pedro");
        car.setYear(2023L );

        when(carsRepository.findById(carsId)).thenReturn(Optional.of(car));

        //when
        carsService.delete(carsId);

        //then
        Mockito.verify(carsRepository).delete(car);
    }

    @Test
    void updateCar() {
        //given
        String carsId = "1";
        CarsDtoRequest carsDtoRequest = new CarsDtoRequest();
        carsDtoRequest.setBrand("Toyota");
        carsDtoRequest.setModel("Corolla");
        carsDtoRequest.setPilot("Jorge");
        carsDtoRequest.setYear(2022L);

        Cars car = new Cars();
        car.setBrand("Honda");
        car.setModel("Civic");
        car.setPilot("John Doe");
        car.setYear(2023L);

        when(carsRepository.findById(carsId)).thenReturn(Optional.of(car));

        //when
        carsService.updateCar(carsId, carsDtoRequest);

        //then
        Mockito.verify(carsRepository).save(car);
    }

}
