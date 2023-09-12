package com.andre.souza.race.controller;

import com.andre.souza.race.dto.CarsDtoRequest;
import com.andre.souza.race.service.CarsService;
import com.andre.souza.race.utils.JsonUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc

public class CarsControllerTest {

    @InjectMocks
    private CarsController carsController;

    @Mock
    private CarsService carsService;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() { mockMvc = MockMvcBuilders.standaloneSetup(carsController).build();
    }

    @AfterEach
    void tearDown() {
    }

    private static final String CARS = "cars.json";

    private static final long STATIC_ID = 1L;

//    @Test
//    void saveStudent() throws Exception {
//        //given
//        String payload = JsonUtils.readFileAsString(CARS);
//        CarsDtoRequest savedCarsDtoRequest = JsonUtils.getObjectFromFile(CARS, CarsDtoRequest.class);
//        when(CarsService.save(any())).thenReturn(savedCarsDtoRequest);
//
//        //then
//        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.post("/cars/post")
//                .content(payload).contentType(MediaType.APPLICATION_JSON);
//        mockMvc.perform(builder).andExpect(MockMvcResultMatchers.status().isOk());
//    }

    @Test
    void get(){
    }

    @Test
    void getAllCars() {
    }
    @Test
    void deleteCars() {
    }

    @Test
    void updateCars() {
    }

}
