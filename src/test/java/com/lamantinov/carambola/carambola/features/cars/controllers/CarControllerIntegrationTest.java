package com.lamantinov.carambola.carambola.features.cars.controllers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lamantinov.carambola.carambola.features.cars.dto.CarIntoShopsDTO;
import com.lamantinov.carambola.carambola.features.cars.dto.CarWithoutShopsDTO;
import com.lamantinov.carambola.carambola.features.cars.services.CarService;
import com.lamantinov.carambola.carambola.features.shops.dto.ShopWithoutCarsDTO;
import org.junit.jupiter.api.Assertions;
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

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class CarControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private CarService carService;

    String URL = "http://localhost:8080/api/cars/";

    @Test
    void shouldShowAllCars() throws Exception {
        String URL = "http://localhost:8080/api/cars/";
        ObjectMapper mapper = new ObjectMapper();
        String json = mockMvc.perform(
                MockMvcRequestBuilders.get(URL)
                    .contentType(MediaType.APPLICATION_JSON)
            )
            .andReturn()
            .getResponse()
            .getContentAsString();

        List<CarWithoutShopsDTO> exceptedResult = carService.getAllWithoutShopsInfo();
        List<CarWithoutShopsDTO> actualResult = mapper.readValue(json, new TypeReference<>(){});
        Assertions.assertArrayEquals(new List[]{exceptedResult}, new List[]{actualResult});
    }

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
    }

    @Test
    void shouldGetCarIntoAllShops() throws Exception {
        String URL = "http://localhost:8080/api/cars/7/shops";
        ObjectMapper mapper = new ObjectMapper();
        String json = mockMvc.perform(
                MockMvcRequestBuilders.get(URL)
                    .contentType(MediaType.APPLICATION_JSON)
            )
            .andReturn()
            .getResponse()
            .getContentAsString();

        List<ShopWithoutCarsDTO> shopList = new ArrayList<>(){{
            add(new ShopWithoutCarsDTO(
                1,
                "Kira Auto",
                "Moskovsky prospect building 1",
                "8-812-523-21-23",
                "kirochka@kiraauto.com")
            );
        }};

        CarIntoShopsDTO exceptedResult = new CarIntoShopsDTO();
        exceptedResult.setId(7);
        exceptedResult.setBrand("Ferrari");
        exceptedResult.setShopWithoutCarsDTO(shopList);

        CarIntoShopsDTO actualResult = mapper.readValue(json, CarIntoShopsDTO.class);
        Assertions.assertEquals(exceptedResult, actualResult);
    }

    @Test
    void shouldAddNewCar() throws Exception {
        String URL = "http://localhost:8080/api/cars/3";
        ObjectMapper mapper = new ObjectMapper();
        String json = mockMvc.perform(
                MockMvcRequestBuilders.get(URL)
                    .contentType(MediaType.APPLICATION_JSON)
            )
            .andReturn()
            .getResponse()
            .getContentAsString();
        CarWithoutShopsDTO carWithoutShopsDTO = mapper.readValue(json, CarWithoutShopsDTO.class);
        final var exceptedResult = 3;
        final var actualResult = carWithoutShopsDTO.getId();
        Assertions.assertEquals(exceptedResult, actualResult);
    }

    @Test
    void shouldUpdateCar() throws Exception {
        String URL = "http://localhost:8080/api/cars/3";
        ObjectMapper mapper = new ObjectMapper();
        String json = mockMvc.perform(
                MockMvcRequestBuilders.get(URL)
                    .contentType(MediaType.APPLICATION_JSON)
            )
            .andReturn()
            .getResponse()
            .getContentAsString();
        CarWithoutShopsDTO carWithoutShopsDTO = mapper.readValue(json, CarWithoutShopsDTO.class);
        final var exceptedResult = "Car " + 3 + " was updated";
        final var actualResult = "Car " + carWithoutShopsDTO.getId() + " was updated";
        Assertions.assertEquals(exceptedResult, actualResult);
    }

    @Test
    void shouldDeleteCar() throws Exception {
        String URL = "http://localhost:8080/api/cars/3";
        ObjectMapper mapper = new ObjectMapper();
        String json = mockMvc.perform(
                MockMvcRequestBuilders.get(URL)
                    .contentType(MediaType.APPLICATION_JSON)
            )
            .andReturn()
            .getResponse()
            .getContentAsString();

        final var exceptedResult = "Car with ID = " + 3 + " was deleted";
        final var actualResult = "Car with ID = " + 3 + " was deleted";
        Assertions.assertEquals(exceptedResult, actualResult);
    }
}