package com.lamantinov.carambola.carambola.features.shops.controllers;

import com.lamantinov.carambola.carambola.features.cars.dto.CarIntoShopsDTO;
import com.lamantinov.carambola.carambola.features.cars.dto.CarWithoutShopsDTO;
import com.lamantinov.carambola.carambola.features.cars.services.CarService;
import com.lamantinov.carambola.carambola.features.shops.dto.ShopWithCarsDTO;
import com.lamantinov.carambola.carambola.features.shops.dto.ShopWithoutCarsDTO;
import com.lamantinov.carambola.carambola.features.shops.services.ShopService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lamantinov.carambola.carambola.features.owners.dto.OwnerWithoutCarsDTO;
import com.lamantinov.carambola.carambola.features.owners.services.OwnerService;
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
class ShopControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ShopService shopService;

    @Test
    void shouldShowAllShops() throws Exception {
        final String URL = "http://localhost:8080/api/shops/";
        final ObjectMapper mapper = new ObjectMapper();
        final String json = mockMvc.perform(
                MockMvcRequestBuilders.get(URL)
                    .contentType(MediaType.APPLICATION_JSON)
            )
            .andReturn()
            .getResponse()
            .getContentAsString();

        final List<ShopWithoutCarsDTO> exceptedResult = shopService.getAllWithoutCarsInfo();
        final List<ShopWithoutCarsDTO> actualResult = mapper.readValue(json, new TypeReference<>(){});
        Assertions.assertArrayEquals(new List[]{exceptedResult}, new List[]{actualResult});

    }

    @Test
    void shouldGetShop() throws Exception {
        final String URL = "http://localhost:8080/api/shops/2";

        mockMvc.perform(
                MockMvcRequestBuilders.get(URL)
                    .contentType(MediaType.APPLICATION_JSON)
            )
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.id", is(2)))
            .andExpect(jsonPath("$.shopName", is("BNW")))
            .andExpect(jsonPath("$.address", is("Moskovsky prospect building 12")))
            .andExpect(jsonPath("$.phone", is("8-812-345-23-12")))
            .andExpect(jsonPath("$.email", is("bnw@bnw.com")));
    }

    @Test
    void shouldGetShopWithCars() throws Exception {
        final String URL = "http://localhost:8080/api/shops/2/cars";
        final ObjectMapper mapper = new ObjectMapper();
        final String json = mockMvc.perform(
                MockMvcRequestBuilders.get(URL)
                    .contentType(MediaType.APPLICATION_JSON)
            )
            .andReturn()
            .getResponse()
            .getContentAsString();

        final List<CarWithoutShopsDTO> carWithoutShopsDTOList = new ArrayList<>(){{
                add(new CarWithoutShopsDTO(1, "Maddyson", 1984, 2000000));
                add(new CarWithoutShopsDTO(2, "Lada", 2006, 900000));
                add(new CarWithoutShopsDTO(4, "Lada", 1999, 700000));
                add(new CarWithoutShopsDTO(6, "BMW", 2018, 7000000));
            }};

        final ShopWithCarsDTO exceptedResult = new ShopWithCarsDTO();
        exceptedResult.setId(2);
        exceptedResult.setShopName("BNW");
        exceptedResult.setCarWithoutShopsDTO(carWithoutShopsDTOList);

        final ShopWithCarsDTO actualResult = mapper.readValue(json, ShopWithCarsDTO.class);
        Assertions.assertEquals(exceptedResult, actualResult);
    }

    @Test
    void shouldAddNewShop() throws Exception {
        final String URL = "http://localhost:8080/api/shops/3";
        final ObjectMapper mapper = new ObjectMapper();
        final String json = mockMvc.perform(
                MockMvcRequestBuilders.get(URL)
                    .contentType(MediaType.APPLICATION_JSON)
            )
            .andReturn()
            .getResponse()
            .getContentAsString();
        final ShopWithoutCarsDTO shopWithoutShopsDTO = mapper.readValue(json, ShopWithoutCarsDTO.class);
        final var exceptedResult = 3;
        final var actualResult = shopWithoutShopsDTO.getId();
        Assertions.assertEquals(exceptedResult, actualResult);
    }

    @Test
    void shouldUpdateShop() throws Exception {
        final String URL = "http://localhost:8080/api/shops/3";
        final ObjectMapper mapper = new ObjectMapper();
        final String json = mockMvc.perform(
                MockMvcRequestBuilders.get(URL)
                    .contentType(MediaType.APPLICATION_JSON)
            )
            .andReturn()
            .getResponse()
            .getContentAsString();
        final ShopWithoutCarsDTO shopWithoutShopsDTO = mapper.readValue(json, ShopWithoutCarsDTO.class);
        final var exceptedResult = "Shop " + 3 + " was updated";
        final var actualResult = "Shop " + shopWithoutShopsDTO.getId() + " was updated";
        Assertions.assertEquals(exceptedResult, actualResult);
    }

    @Test
    void shouldDeleteShop() throws Exception {
        final String URL = "http://localhost:8080/api/shops/3";
        final ObjectMapper mapper = new ObjectMapper();
        final String json = mockMvc.perform(
                MockMvcRequestBuilders.get(URL)
                    .contentType(MediaType.APPLICATION_JSON)
            )
            .andReturn()
            .getResponse()
            .getContentAsString();

        final ShopWithoutCarsDTO shopWithoutCarsDTO = mapper.readValue(json, ShopWithoutCarsDTO.class);
        final var exceptedResult = "Car with ID = " + 3 + " was deleted";
        final var actualResult = "Car with ID = " + shopWithoutCarsDTO.getId() + " was deleted";
        Assertions.assertEquals(exceptedResult, actualResult);
    }
}