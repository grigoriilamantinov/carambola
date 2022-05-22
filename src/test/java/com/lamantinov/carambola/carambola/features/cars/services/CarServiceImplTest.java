package com.lamantinov.carambola.carambola.features.cars.services;

import com.lamantinov.carambola.carambola.CarambolaApplication;
import com.lamantinov.carambola.carambola.features.cars.dao.CarRepository;
import com.lamantinov.carambola.carambola.features.cars.dto.CarWithoutShopsDTO;
import com.lamantinov.carambola.carambola.features.cars.entity.Car;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = {CarambolaApplication.class})
class CarServiceImplTest {

    @Mock private CarRepository carRepository;

    private CarService testable;

    @BeforeEach
    void setUp() {
        testable = new CarServiceImpl(carRepository);
    }

    @Test
    void shouldGetCarWithoutShopsById() {
        final int carId = 1;

        final Car car = new Car();
        car.setId(carId);
        car.setBrand("Lamantan");
        car.setNetWorth(123142);
        car.setYearOfProduce(1984);

        final var expectedResult = new CarWithoutShopsDTO();
        expectedResult.setId(carId);
        expectedResult.setYearOfProduce(1984);
        expectedResult.setBrand("Lamantan");
        expectedResult.setNetWorth(123142);

        Mockito.when(carRepository.getById(carId)).thenReturn(car);

        var actualResult = testable.getCarWithoutShopsById(carId);

        Assertions.assertEquals(expectedResult, actualResult);

        Mockito.verify(carRepository).getById(carId);
    }
}