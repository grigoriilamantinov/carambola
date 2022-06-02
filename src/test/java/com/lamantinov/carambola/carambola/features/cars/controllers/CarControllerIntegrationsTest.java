package com.lamantinov.carambola.carambola.features.cars.controllers;

import com.lamantinov.carambola.carambola.features.shops.services.ShopService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class CarControllerIntegrationsTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldGetShops() throws Exception {
        final String URL = "http://localhost:8080/cars/";
        mockMvc.perform(
                MockMvcRequestBuilders.get(URL)
                    .contentType(MediaType.APPLICATION_JSON)
            )
            .andExpect(status().isOk())
            .andReturn()
            .getResponse()
            .getContentAsString();
    }

    @Test
    void shouldShowOneCar() throws Exception {
        final String URL = "http://localhost:8080/cars/2";
        mockMvc.perform(
                MockMvcRequestBuilders.get(URL)
                    .contentType(MediaType.APPLICATION_JSON)
            )
            .andExpect(status().isOk())
            .andReturn()
            .getResponse()
            .getContentAsString();
    }

    @Test
    void shouldAddNewCar() throws Exception {
        final String URL = "http://localhost:8080/cars/addNewCar";
        mockMvc.perform(
                MockMvcRequestBuilders.get(URL)
                    .contentType(MediaType.APPLICATION_JSON)
            )
            .andExpect(status().isOk())
            .andReturn()
            .getResponse()
            .getContentAsString();
    }

    @Test
    void shouldUpdateCar() throws Exception {
        final String URL = "http://localhost:8080/cars/2/updateCar";
        mockMvc.perform(
                MockMvcRequestBuilders.get(URL)
                    .contentType(MediaType.APPLICATION_JSON)
            )
            .andExpect(status().isOk())
            .andReturn()
            .getResponse()
            .getContentAsString();
    }

    @Test
    void shouldSaveCar() throws Exception {
        final String URL = "http://localhost:8080/cars/saveCar";
        mockMvc.perform(
                MockMvcRequestBuilders.get(URL)
                    .contentType(MediaType.APPLICATION_JSON)
            )
            .andExpect(status().is4xxClientError())
            .andReturn()
            .getResponse()
            .getContentAsString();
    }
}