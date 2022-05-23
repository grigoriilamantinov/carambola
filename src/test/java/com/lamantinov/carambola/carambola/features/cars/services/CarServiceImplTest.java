package com.lamantinov.carambola.carambola.features.cars.services;

import com.lamantinov.carambola.carambola.CarambolaApplication;
import com.lamantinov.carambola.carambola.features.cars.dao.CarRepository;
import com.lamantinov.carambola.carambola.features.cars.dto.CarIntoShopsDTO;
import com.lamantinov.carambola.carambola.features.cars.dto.CarWithoutShopsDTO;
import com.lamantinov.carambola.carambola.features.cars.entity.Car;
import com.lamantinov.carambola.carambola.features.shops.dto.ShopWithoutCarsDTO;
import com.lamantinov.carambola.carambola.features.shops.entity.Shop;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = {CarambolaApplication.class})
class CarServiceImplTest {

    @Mock
    private CarRepository carRepository;

    private CarService testable;

    @BeforeEach
    void setUp() {
        testable = new CarServiceImpl(carRepository);
    }

    @Test
    void getAll() {
        final List<Car> carList = new ArrayList<>(){{
            add(new Car(1, "BNW", 2000, 2000000));
            add(new Car(2, "Lada", 2006, 1900000));
        }};

        final var exceptedResult = new ArrayList<>(){{
            add(carList.get(0));
            add(carList.get(1));
        }};

        Mockito.when(carRepository.findAll()).thenReturn(carList);

        final var actualResult = testable.getAll();

        Assertions.assertEquals(exceptedResult, actualResult);
        Mockito.verify(carRepository).findAll();
    }

    @Test
    void getAllWithoutShopsInfo() {
        final List<Car> carList = new ArrayList<>(){{
            add(new Car(1, "BNW", 2000, 2000000));
            add(new Car(2, "Lada", 2006, 1900000));
        }};

        final List<CarWithoutShopsDTO> exceptedResult = new ArrayList<>(){{
            add(new CarWithoutShopsDTO(1, "BNW", 2000, 2000000));
            add(new CarWithoutShopsDTO(2, "Lada", 2006, 1900000));
        }};

        Mockito.when(carRepository.findAll()).thenReturn(carList);

        final var actualResult = testable.getAllWithoutShopsInfo();

        Assertions.assertEquals(exceptedResult, actualResult);
        Mockito.verify(carRepository).findAll();
    }

    @Test
    void getCarIntoShops() {
        final int carId = 0;

        final List<Shop> shopList = new ArrayList<>() {{
            add(new Shop(1, "HelloShop", "Moscow street", "546-23-12", "xq@mail.ru" ));
            add(new Shop(2, "CarShop", "Village street", "126-23-62", "bi@mail.ru" ));
        }};

        final List<ShopWithoutCarsDTO> shopWithoutCarsDTO = new ArrayList<>(){{
            add(ShopWithoutCarsDTO.of(shopList.get(0)));
            add(ShopWithoutCarsDTO.of(shopList.get(1)));
        }};

        final Car car = new Car();
        car.setId(carId);
        car.setBrand("Lada");
        car.setYearOfProduce(2006);
        car.setNetWorth(500400);
        car.setShops(shopList);

        final var expectedResult = new CarIntoShopsDTO();
        expectedResult.setId(car.getId());
        expectedResult.setBrand(car.getBrand());
        expectedResult.setShopWithoutCarsDTO(shopWithoutCarsDTO);

        Mockito.when(carRepository.getById(carId)).thenReturn(car);

        var actualResult = testable.getCarIntoShops(carId);

        Assertions.assertEquals(expectedResult, actualResult);
        Mockito.verify(carRepository).getById(carId);
    }

    @Test
    void getCarsWithoutShopsById() {
        final int carId = 1;
        final List<Car> carList = new ArrayList<>(){{
            add(new Car(1, "BNW", 2000, 2000000));
            add(new Car(2, "Lada", 2006, 1900000));
        }};

        Car car = carList.get(carId);

        final CarWithoutShopsDTO exceptedResult = new CarWithoutShopsDTO();
        exceptedResult.setId(car.getId());
        exceptedResult.setBrand(car.getBrand());
        exceptedResult.setYearOfProduce(car.getYearOfProduce());
        exceptedResult.setNetWorth(car.getNetWorth());

        Mockito.when(carRepository.getById(carId)).thenReturn(car);

        final var actualResult = testable.getCarsWithoutShopsById(carId);

        Assertions.assertEquals(exceptedResult, actualResult);
        Mockito.verify(carRepository).getById(carId);
    }
}