package com.lamantinov.carambola.carambola.features.cars.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lamantinov.carambola.carambola.CarambolaApplication;
import com.lamantinov.carambola.carambola.features.cars.dto.CarWithoutShopsDTO;
import com.lamantinov.carambola.carambola.features.owners.dto.OwnerWithoutCarsDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class CarControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldGetCar() throws Exception {
        String URL = "http://localhost:8080/api/cars/2";

        mockMvc.perform(
                MockMvcRequestBuilders.get(URL)
                    .contentType(MediaType.APPLICATION_JSON)
            )
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.id", is(2)))
            .andExpect(jsonPath("$.brand", is("Lada")))
            .andExpect(jsonPath("$.yearOfProduce", is(2006)))
            .andExpect(jsonPath("$.netWorth", is(900000)));

        ObjectMapper mapper = new ObjectMapper();
//        String json = mockMvc.perform(
//                MockMvcRequestBuilders.get(URL)
//                    .contentType(MediaType.APPLICATION_JSON)
//        )
//            .andReturn()
//            .getResponse()
//            .getContentAsString();
//
//        var result = mapper.readValue(json, CarWithoutShopsDTO.class);

        var car = new CarWithoutShopsDTO(2, "Lada", 2006, 900000);
        String json = mapper.writeValueAsString(car);
    }
}