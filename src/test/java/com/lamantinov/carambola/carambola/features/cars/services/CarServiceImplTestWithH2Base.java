package com.lamantinov.carambola.carambola.features.cars.services;

import com.lamantinov.carambola.carambola.CarambolaApplication;
import com.lamantinov.carambola.carambola.features.cars.dto.CarIntoShopsDTO;
import com.lamantinov.carambola.carambola.features.cars.dto.CarWithoutShopsDTO;
import com.lamantinov.carambola.carambola.features.cars.entity.Car;
import com.lamantinov.carambola.carambola.features.shops.dto.ShopWithoutCarsDTO;
import com.lamantinov.carambola.carambola.features.shops.entity.Shop;
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

@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@Transactional
@SpringBootTest(classes = {CarambolaApplication.class})
class CarServiceImplTestWithH2Base {

    @Autowired
    private CarService carService;

    @Test
    void getAll() {
        List<Shop> shopList = new ArrayList<>(){{
            add(new Shop(
                1,
                "Кира Ауто",
                "Moskovsky prospect building 1",
                "8-812-523-21-23",
                "kirochka@kiraauto.com")
            );
            add(new Shop(
                2,
                "BNW",
                "Moskovsky prospect building 12",
                "8-812-345-23-12",
                "bnw@bnw.com")
            );
            add(new Shop(
                3,
                "Е-мобилс",
                "Enthusiasts Avenue 12",
                "8-812-526-31-21",
                "e-mobils@cash.com")
            );
        }};

        List<Car> carList = new ArrayList<>(){{
            add(new Car(1, "Maddyson", 1984, 2000000, shopList.get()));
            add(new Car(2, "Lada", 2006, 900000, shopList));
            add(new Car(3, "GAZ", 2010, 1000000, shopList));
            add(new Car(4, "Lada", 1999, 700000, shopList));
            add(new Car(5, "Lada", 2007, 3000000, shopList));
            add(new Car(6, "BMW", 2018, 7000000, shopList));
            add(new Car(7, "Ferrari", 2020, 12000000, shopList));
            add(new Car(8, "Yo-mobil", 2010, 9990000, shopList));
        }};

        var actualResult = carService.getAll();
        Assertions.assertEquals(actualResult, carList);
    }

    @Test
    void getAllWithoutShopsInfo() {
    }

    @Test
    void getCarIntoShops() {
        List<ShopWithoutCarsDTO> shopWithoutCarsDTO = new ArrayList<>(){{
            add(new ShopWithoutCarsDTO(
                1,
                "Кира Ауто",
                "Moskovsky prospect building 1",
                "8-812-523-21-23",
                "kirochka@kiraauto.com")
            );
        }};
        var exceptedResult = new CarIntoShopsDTO();
        exceptedResult.setBrand("GAZ");
        exceptedResult.setId(3);
        exceptedResult.setShopWithoutCarsDTO(shopWithoutCarsDTO);
        var actualResult = carService.getCarIntoShops(3);
        Assertions.assertEquals(actualResult, exceptedResult);
    }

    @Test
    void save() {
    }

    @Test
    void getById() {

    }

    @Test
    void getCarsWithoutShopsById() {
        var exceptedResult = new CarWithoutShopsDTO(3, "GAZ", 2010, 1000000);
        var actualResult = carService.getCarsWithoutShopsById(3);
        Assertions.assertEquals(exceptedResult, actualResult);
    }

    @Test
    void delete() {
        List<Car> exceptedResult = new ArrayList<>(){{
            add(new Car(2, "Lada", 2006, 900000));
            add(new Car(3, "GAZ", 2010, 1000000));
            add(new Car(4, "Lada", 1999, 700000));
            add(new Car(5, "Lada", 2007, 3000000));
            add(new Car(6, "BMW", 2018, 7000000));
            add(new Car(7, "Ferrari", 2020, 12000000));
            add(new Car(8, "Yo-mobil", 2010, 9990000));
        }};
        carService.delete(1);
        var actualResult = carService.getAll();

        Assertions.assertEquals(exceptedResult.size(), actualResult.size());
//        Assertions.assertTrue(actualResult.containsAll(exceptedResult));
//        Assertions.assertIterableEquals(exceptedResult, actualResult);
    }
}