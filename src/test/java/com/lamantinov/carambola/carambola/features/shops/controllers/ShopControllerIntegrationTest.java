package com.lamantinov.carambola.carambola.features.shops.controllers;

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

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class ShopControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldGetShops() throws Exception {
        final String URL = "http://localhost:8080/shops/";
        mockMvc.perform(
                MockMvcRequestBuilders.get(URL)
                    .contentType(MediaType.APPLICATION_JSON)
            )
            .andExpect(status().isOk());
    }

    @Test
    void shouldShowCars() throws Exception {
        final String URL = "http://localhost:8080/shops/2/cars";
        mockMvc.perform(
                MockMvcRequestBuilders.get(URL)
                    .contentType(MediaType.APPLICATION_JSON)
            )
            .andExpect(status().isOk());
    }

    @Test
    void shouldShowShops() throws Exception {
        final String URL = "http://localhost:8080/shops/2";
        mockMvc.perform(
                MockMvcRequestBuilders.get(URL)
                    .contentType(MediaType.APPLICATION_JSON)
            )
            .andExpect(status().isOk());
    }

    @Test
    void shouldDeleteCarFromShop() throws Exception {
        final String URL = "http://localhost:8080/shops/2/car/2";
        mockMvc.perform(
                MockMvcRequestBuilders.delete(URL)
                    .contentType(MediaType.APPLICATION_JSON)
            )
            .andExpect(status().is3xxRedirection());
    }

    @Test
    void shouldAddCarIntoShop() throws Exception {
        final String URL = "http://localhost:8080/shops/2/add/3";
        mockMvc.perform(
                MockMvcRequestBuilders.put(URL)
                    .contentType(MediaType.APPLICATION_JSON)
            )
            .andExpect(status().is3xxRedirection());
    }

    @Test
    void shouldShowAddPage() throws Exception {
        final String URL = "http://localhost:8080/shops/2/addPage";
        mockMvc.perform(
                MockMvcRequestBuilders.get(URL)
                    .contentType(MediaType.APPLICATION_JSON)
            )
            .andExpect(status().isOk());
    }
}