package com.lamantinov.carambola.carambola.features.cars.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class CarControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    String URL = "http://localhost:8080/api/cars";

    @Test
    void showAllCars() {
    }

    @Test
    void getCar() throws Exception {
        String URL = "http://localhost:8080/api/cars/2";

        mockMvc.perform(
            MockMvcRequestBuilders.get(URL)
                .contentType(MediaType.APPLICATION_JSON)
        )
            .andExpect(status().isOk())
            .andExpect((ResultMatcher) jsonPath("$.id",is(2)))
            .andExpect((ResultMatcher) jsonPath("$.brand",is("Lada")))
            .andExpect((ResultMatcher) jsonPath("$.yearOfProduce",is(2006)))
            .andExpect((ResultMatcher) jsonPath("$.netWorth",is(900000)));
//        ObjectMapper mapper = new ObjectMapper();
//        String json = mockMvc.perform(
//            MockMvcRequestBuilders.get(URL)
//        )
    }

    @Test
    void getCarIntoAllShops() {
        String URL = "http://localhost:8080/api/cars";
    }

    @Test
    void addNewCar() {
        String URL = "http://localhost:8080/api/cars";
    }

    @Test
    void updateCar() {
        String URL = "http://localhost:8080/api/cars";
    }

    @Test
    void deleteCar() {
        String URL = "http://localhost:8080/api/cars";
    }
}