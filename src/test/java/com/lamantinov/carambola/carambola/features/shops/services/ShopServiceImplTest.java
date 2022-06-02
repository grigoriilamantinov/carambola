package com.lamantinov.carambola.carambola.features.shops.services;

import com.lamantinov.carambola.carambola.CarambolaApplication;
import com.lamantinov.carambola.carambola.features.cars.dto.CarWithoutShopsDTO;
import com.lamantinov.carambola.carambola.features.cars.entity.Car;
import com.lamantinov.carambola.carambola.features.cars.services.CarService;
import com.lamantinov.carambola.carambola.features.shops.dao.ShopRepository;
import com.lamantinov.carambola.carambola.features.shops.dto.ShopWithCarsDTO;
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
class ShopServiceImplTest {

    @Mock
    private ShopRepository shopRepository;

    private CarService carService;

    private ShopService testable;


    @BeforeEach
    void setUp() {
        testable = new ShopServiceImpl(shopRepository, carService);
    }

    @Test
    void shouldGetAllWithoutCarsInfo() {
        List<Shop> shopList = new ArrayList<>(){{
            add(new Shop(
                1,
                "HelloShop",
                "Moscow street",
                "546-23-12",
                "xq@mail.ru"
            ));
            add(new Shop(
                2, "CarShop",
                "Village street",
                "126-23-62",
                "bi@mail.ru"
            ));
        }};

        List<ShopWithoutCarsDTO> exceptedResult = new ArrayList<>(){{
            add(new ShopWithoutCarsDTO(
                1,
                "HelloShop",
                "Moscow street",
                "546-23-12",
                "xq@mail.ru"
            ));
            add(new ShopWithoutCarsDTO(
                2, "CarShop",
                "Village street",
                "126-23-62",
                "bi@mail.ru"
            ));
        }};

        Mockito.when(shopRepository.findAll()).thenReturn(shopList);
        var actualResult = testable.getAllWithoutCarsInfo();

        Assertions.assertEquals(actualResult, exceptedResult);
        Mockito.verify(shopRepository).findAll();
    }

    @Test
    void shouldGetCarsIntoShop() {
        final int shopId = 1;

        final List<Car> carList = new ArrayList<>(){{
            add(new Car(1, "BNW", 2000, 2000000));
            add(new Car(2, "Mlada", 2006, 1900000));
        }};

        final List<CarWithoutShopsDTO> carWithoutShopsDTO = new ArrayList<>(){{
            add(CarWithoutShopsDTO.of(carList.get(0)));
            add(CarWithoutShopsDTO.of(carList.get(1)));
        }};

        Shop shop = new Shop(
            1,
            "CarShop",
            "Village street",
            "126-23-62",
            "bi@mail.ru"
        );
        shop.setCars(carList);

        ShopWithCarsDTO exceptedResult = new ShopWithCarsDTO();
        exceptedResult.setShopName(shop.getShopName());
        exceptedResult.setId(shop.getId());
        exceptedResult.setCarWithoutShopsDTO(carWithoutShopsDTO);

        Mockito.when(shopRepository.getById(shopId)).thenReturn(shop);
        var actualResult = testable.getCarsIntoShop(shopId);

        Assertions.assertEquals(actualResult, exceptedResult);
        Mockito.verify(shopRepository).getById(shopId);
    }

    @Test
    void shouldGetShopWithoutCarsById() {
        final int shopId = 1;
        Shop shop = new Shop(
            1,
            "CarShop",
            "Village street",
            "126-23-62",
            "bi@mail.ru"
        );

        var exceptedResult = new ShopWithoutCarsDTO();
        exceptedResult.setId(1);
        exceptedResult.setShopName("CarShop");
        exceptedResult.setAddress("Village street");
        exceptedResult.setPhone("126-23-62");
        exceptedResult.setEmail("bi@mail.ru");

        Mockito.when(shopRepository.getById(shopId)).thenReturn(shop);
        var actualResult = testable.getShopWithoutCarsById(shopId);

        Assertions.assertEquals(actualResult, exceptedResult);
        Mockito.verify(shopRepository).getById(shopId);
    }
}