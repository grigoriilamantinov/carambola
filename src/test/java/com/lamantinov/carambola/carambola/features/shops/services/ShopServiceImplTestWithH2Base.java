package com.lamantinov.carambola.carambola.features.shops.services;

import com.lamantinov.carambola.carambola.CarambolaApplication;
import com.lamantinov.carambola.carambola.features.cars.dto.CarWithoutShopsDTO;
import com.lamantinov.carambola.carambola.features.shops.dto.ShopWithCarsDTO;
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
class ShopServiceImplTestWithH2Base {

    @Autowired
    ShopService shopService;

    @Test
    void shouldGetAllWithoutCarsInfo() {
        final var exceptedResult = new ArrayList<>(){{
            add(new ShopWithoutCarsDTO(
                1,
                "Kira Auto",
                "Moskovsky prospect building 1",
                "8-812-523-21-23",
                "kirochka@kiraauto.com")
            );
            add(new ShopWithoutCarsDTO(
                2,
                "BNW",
                "Moskovsky prospect building 12",
                "8-812-345-23-12",
                "bnw@bnw.com")
            );
            add(new ShopWithoutCarsDTO(
                3,
                "E-mobils",
                "Enthusiasts Avenue 12",
                "8-812-526-31-21",
                "e-mobils@cash.com")
            );
        }};
        final var actualResult = shopService.getAllWithoutCarsInfo();
        Assertions.assertEquals(exceptedResult, actualResult);
    }

    @Test
    void shouldGetCarsIntoShop() {
        final int shopId = 2;
        final Shop shop = shopService.getById(shopId);
        final List<CarWithoutShopsDTO> carWithoutShopsDTOList = new ArrayList<>(){{
            add(new CarWithoutShopsDTO(1, "Maddyson", 1984, 2000000));
            add(new CarWithoutShopsDTO(2, "Lada", 2006, 900000));
            add(new CarWithoutShopsDTO(4, "Lada", 1999, 700000));
            add(new CarWithoutShopsDTO(6, "BMW", 2018, 7000000));
        }};
        final ShopWithCarsDTO exceptedResult = new ShopWithCarsDTO();
        exceptedResult.setId(shop.getId());
        exceptedResult.setShopName(shop.getShopName());
        exceptedResult.setCarWithoutShopsDTO(carWithoutShopsDTOList);

        final var actualResult = shopService.getCarsIntoShop(shopId);
        Assertions.assertEquals(exceptedResult, actualResult);
    }

    @Test
    void shouldGetShopWithoutCarsById() {
        final int shopId = 1;
        final var exceptedResult = new ShopWithoutCarsDTO(
            1,
            "Kira Auto",
            "Moskovsky prospect building 1",
            "8-812-523-21-23",
            "kirochka@kiraauto.com"
        );
        final var actualResult = shopService.getShopWithoutCarsById(shopId);
        Assertions.assertEquals(exceptedResult, actualResult);
    }
}