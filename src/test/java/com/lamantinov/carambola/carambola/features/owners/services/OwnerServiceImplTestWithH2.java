package com.lamantinov.carambola.carambola.features.owners.services;

import com.lamantinov.carambola.carambola.CarambolaApplication;
import com.lamantinov.carambola.carambola.features.owners.dto.OwnerWithoutCarsDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@Transactional
@SpringBootTest(classes = {CarambolaApplication.class})
class OwnerServiceImplTestWithH2 {

    @Autowired private OwnerService ownerService;

    @Test
    void shouldGetByIdWithoutCar() {
        var expectedResult = new OwnerWithoutCarsDTO(4, "Али", "Дон-Донович");
        var actualResult = ownerService.getByIdWithoutCar(4);
        Assertions.assertEquals(expectedResult, actualResult);
    }
}