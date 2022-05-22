package com.lamantinov.carambola.carambola.features.shops.services;

import com.lamantinov.carambola.carambola.features.shops.dto.ShopWithCarsDTO;
import com.lamantinov.carambola.carambola.features.shops.dto.ShopWithoutCarsDTO;
import com.lamantinov.carambola.carambola.features.shops.entity.Shop;
import com.lamantinov.carambola.carambola.features.common.CarambolaCRUD;

import java.util.List;

public interface ShopService extends CarambolaCRUD<Shop> {
    List<ShopWithoutCarsDTO> getAllWithoutCarsInfo();

    ShopWithCarsDTO getCarsIntoShop(int shopId);

    ShopWithoutCarsDTO getShopWithoutCarsById(int shopId);
}
