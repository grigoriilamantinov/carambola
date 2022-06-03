package com.lamantinov.carambola.carambola.features.owners.services;

import com.lamantinov.carambola.carambola.CarambolaApplication;
import com.lamantinov.carambola.carambola.features.cars.dto.CarWithoutShopsDTO;
import com.lamantinov.carambola.carambola.features.owners.dto.OwnerWithoutCarsDTO;
import com.lamantinov.carambola.carambola.features.owners.dto.OwnersCarDTO;
import com.lamantinov.carambola.carambola.features.owners.entity.Owner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@Transactional
@SpringBootTest(classes = CarambolaApplication.class)
class OwnerServiceImplTestWithH2Base {

    @Autowired
    private OwnerService ownerService;

    @Test
    void shouldGetAllWithoutCarsInfo() {
        final List<OwnerWithoutCarsDTO> exceptedResult = new ArrayList<>(){{
            add(new OwnerWithoutCarsDTO(1,"Michail", "Shishkin"));
            add(new OwnerWithoutCarsDTO(2,"Mihael","Shumaher"));
            add(new OwnerWithoutCarsDTO(3,"Capybar","Grigorievich"));
            add(new OwnerWithoutCarsDTO(4,"Ali", "Don-Donovich"));
            add(new OwnerWithoutCarsDTO(5,"Emanuil","Kunt"));
            add(new OwnerWithoutCarsDTO(6,"Ivan","Ivaniv"));
        }};
        final var actualResult = ownerService.getAllWithoutCarsInfo();
        Assertions.assertEquals(exceptedResult, actualResult);
    }

    @Test
    void shouldGetOwnersCarById() {
        final int ownerId = 2;

        final Owner owner = new Owner(2, "Mihael", "Shumaher");
        final CarWithoutShopsDTO carWithoutShopsDTO = new CarWithoutShopsDTO(
            2,
            "Lada",
            2006,
            900000
        );

        final var exceptedResult = new OwnersCarDTO();
        exceptedResult.setFirstName(owner.getFirstName());
        exceptedResult.setLastName(owner.getLastName());
        exceptedResult.setCarWithoutShopsDTO(carWithoutShopsDTO);

        final var actualResult = ownerService.getOwnersCarById(ownerId);
        Assertions.assertEquals(exceptedResult, actualResult);
    }

    @Test
    void shouldGetByIdWithoutCar() {
        final var exceptedResult = new OwnerWithoutCarsDTO(2, "Mihael", "Shumaher");
        final int ownerId = 2;
        final var actualResult = ownerService.getByIdWithoutCar(ownerId) ;
        Assertions.assertEquals(exceptedResult, actualResult);
    }
}