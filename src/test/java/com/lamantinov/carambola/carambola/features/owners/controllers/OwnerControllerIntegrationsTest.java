package com.lamantinov.carambola.carambola.features.owners.controllers;

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

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class OwnerControllerIntegrationsTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private OwnerService ownerService;

    @Test
    void shouldShowAllOwners() throws Exception {
        final String URL = "http://localhost:8080/api/owners/";
        final ObjectMapper mapper = new ObjectMapper();
        final String json = mockMvc.perform(
                MockMvcRequestBuilders.get(URL)
                    .contentType(MediaType.APPLICATION_JSON)
            )
            .andReturn()
            .getResponse()
            .getContentAsString();

        final List<OwnerWithoutCarsDTO> exceptedResult = ownerService.getAllWithoutCarsInfo();
        final List<OwnerWithoutCarsDTO> actualResult = mapper.readValue(json, new TypeReference<>(){});
        Assertions.assertArrayEquals(new List[]{exceptedResult}, new List[]{actualResult});
    }

    @Test
    void shouldGetOwner() throws Exception {
        final String URL = "http://localhost:8080/api/owners/2";

        mockMvc.perform(
                MockMvcRequestBuilders.get(URL)
                    .contentType(MediaType.APPLICATION_JSON)
            )
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.id", is(2)))
            .andExpect(jsonPath("$.firstName", is("Mihael")))
            .andExpect(jsonPath("$.lastName", is("Shumaher")));
    }

    @Test
    void shouldAddNewOwner() throws Exception {
        final String URL = "http://localhost:8080/api/owners/3";
        final ObjectMapper mapper = new ObjectMapper();
        final String json = mockMvc.perform(
                MockMvcRequestBuilders.get(URL)
                    .contentType(MediaType.APPLICATION_JSON)
            )
            .andReturn()
            .getResponse()
            .getContentAsString();
        final OwnerWithoutCarsDTO ownerWithoutCarsDTO = mapper.readValue(json, OwnerWithoutCarsDTO.class);
        final var exceptedResult = 3;
        final var actualResult = ownerWithoutCarsDTO.getId();
        Assertions.assertEquals(exceptedResult, actualResult);
    }

    @Test
    void shouldUpdateOwner() throws Exception {
        String URL = "http://localhost:8080/api/owners/3";
        ObjectMapper mapper = new ObjectMapper();
        String json = mockMvc.perform(
                MockMvcRequestBuilders.get(URL)
                    .contentType(MediaType.APPLICATION_JSON)
            )
            .andReturn()
            .getResponse()
            .getContentAsString();
        OwnerWithoutCarsDTO ownerWithoutCarsDTO = mapper.readValue(json, OwnerWithoutCarsDTO.class);
        final var exceptedResult = "Owner " + 3 + " was updated";
        final var actualResult = "Owner " + ownerWithoutCarsDTO.getId() + " was updated";
        Assertions.assertEquals(exceptedResult, actualResult);
    }

    @Test
    void shouldDeleteOwner() throws Exception {
        final String URL = "http://localhost:8080/api/owners/3";
        final ObjectMapper mapper = new ObjectMapper();
        final String json = mockMvc.perform(
                MockMvcRequestBuilders.get(URL)
                    .contentType(MediaType.APPLICATION_JSON)
            )
            .andReturn()
            .getResponse()
            .getContentAsString();
        final OwnerWithoutCarsDTO ownerWithoutCarsDTO = mapper.readValue(json, OwnerWithoutCarsDTO.class);
        final var exceptedResult = "Owner " + 3 + " was deleted";
        final var actualResult = "Owner " + ownerWithoutCarsDTO.getId() + " was deleted";
        Assertions.assertEquals(exceptedResult, actualResult);
    }

    @Test
    void shouldGetOwnersCar() throws Exception {
        final String URL = "http://localhost:8080/api/owners/2/car";

        mockMvc.perform(
                MockMvcRequestBuilders.get(URL)
                    .contentType(MediaType.APPLICATION_JSON)
            )
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.carWithoutShopsDTO.brand", is("Lada")))
            .andExpect(jsonPath("$.carWithoutShopsDTO.yearOfProduce", is(2006)))
            .andExpect(jsonPath("$.firstName", is("Mihael")))
            .andExpect(jsonPath("$.lastName", is("Shumaher")));
    }
}