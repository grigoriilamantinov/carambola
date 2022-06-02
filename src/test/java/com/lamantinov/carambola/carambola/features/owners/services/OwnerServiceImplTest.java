package com.lamantinov.carambola.carambola.features.owners.services;

import com.lamantinov.carambola.carambola.CarambolaApplication;
import com.lamantinov.carambola.carambola.features.cars.dto.CarWithoutShopsDTO;
import com.lamantinov.carambola.carambola.features.cars.entity.Car;
import com.lamantinov.carambola.carambola.features.owners.dao.OwnerRepository;
import com.lamantinov.carambola.carambola.features.owners.dto.OwnerWithoutCarsDTO;
import com.lamantinov.carambola.carambola.features.owners.dto.OwnersCarDTO;
import com.lamantinov.carambola.carambola.features.owners.entity.Owner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("test")
@SpringBootTest(classes = {CarambolaApplication.class})
class OwnerServiceImplTest {

    @Mock
    private OwnerRepository ownerRepository;

    private OwnerService testable;

    @BeforeEach
    void setUp() {
        testable = new OwnerServiceImpl(ownerRepository);
    }

    @Test
    void shouldGetAllWithoutCarsInfo() {
        final List<Owner> ownerList = new ArrayList<>(){{
            add(new Owner(1,"Григорий", "Капибаренко"));
            add(new Owner(2,"Виктор","Хомяков"));
        }};

        final List<OwnerWithoutCarsDTO> exceptedResult = new ArrayList<>(){{
            add(new OwnerWithoutCarsDTO(1,"Григорий", "Капибаренко"));
            add(new OwnerWithoutCarsDTO(2,"Виктор","Хомяков"));
        }};

        Mockito.when(ownerRepository.findAll()).thenReturn(ownerList);
        final var actualResult = testable.getAllWithoutCarsInfo();

        Assertions.assertEquals(actualResult, exceptedResult);
        Mockito.verify(ownerRepository).findAll();
    }

    @Test
    void shouldGetOwnersCarById() {
        final int ownerId = 1;

        final Car car = new Car();
        car.setId(1);
        car.setBrand("Lada");
        car.setYearOfProduce(2006);
        car.setNetWorth(500400);

        final CarWithoutShopsDTO carWithoutShopsDTO = CarWithoutShopsDTO.of(car);

        final Owner owner = new Owner();
        owner.setId(1);
        owner.setFirstName("Григорий");
        owner.setLastName("Капибаренко");
        owner.setCar(car);

        final var exceptedResult = new OwnersCarDTO();
        exceptedResult.setFirstName("Григорий");
        exceptedResult.setLastName("Капибаренко");
        exceptedResult.setCarWithoutShopsDTO(carWithoutShopsDTO);

        Mockito.when(ownerRepository.getById(ownerId)).thenReturn(owner);

        final var actualResult = testable.getOwnersCarById(ownerId);

        Assertions.assertEquals(actualResult, exceptedResult);
        Mockito.verify(ownerRepository).getById(ownerId);
    }

    @Test
    void shouldGetByIdWithoutCar() {
        final int ownerId = 1;

        final Owner owner = new Owner();
        owner.setId(1);
        owner.setFirstName("Григорий");
        owner.setLastName("Капибаренко");

        final var exceptedResult = new OwnerWithoutCarsDTO();
        exceptedResult.setId(1);
        exceptedResult.setFirstName("Григорий");
        exceptedResult.setLastName("Капибаренко");

        Mockito.when(ownerRepository.getById(ownerId)).thenReturn(owner);

        var actualResult = testable.getByIdWithoutCar(ownerId);

        Assertions.assertEquals(exceptedResult, actualResult);
        Mockito.verify(ownerRepository).getById(ownerId);
    }
}