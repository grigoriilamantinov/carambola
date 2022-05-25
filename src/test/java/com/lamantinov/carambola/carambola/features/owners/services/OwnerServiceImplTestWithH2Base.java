package com.lamantinov.carambola.carambola.features.owners.services;

import com.lamantinov.carambola.carambola.CarambolaApplication;
import com.lamantinov.carambola.carambola.features.cars.dto.CarWithoutShopsDTO;
import com.lamantinov.carambola.carambola.features.cars.entity.Car;
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
            add(new OwnerWithoutCarsDTO(1,"Михаил", "Шишкин"));
            add(new OwnerWithoutCarsDTO(2,"Михаэль","Шумахер"));
            add(new OwnerWithoutCarsDTO(3,"Капибар","Григорьевич"));
            add(new OwnerWithoutCarsDTO(4,"Али", "Дон-Донович"));
            add(new OwnerWithoutCarsDTO(5,"Имануил","Кант"));
            add(new OwnerWithoutCarsDTO(6,"Иван","Иванов"));
        }};
        final var actualResult = ownerService.getAllWithoutCarsInfo();
        Assertions.assertEquals(exceptedResult, actualResult);
    }

    @Test
    void shouldGetOwnersCarById() {
        final int ownerId = 2;

        final Owner owner = new Owner(2, "Михаэль", "Шумахер");
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
        final var exceptedResult = new OwnerWithoutCarsDTO(2, "Михаэль", "Шумахер");
        final int ownerId = 2;
        final var actualResult = ownerService.getByIdWithoutCar(ownerId) ;
        Assertions.assertEquals(exceptedResult, actualResult);
    }
}