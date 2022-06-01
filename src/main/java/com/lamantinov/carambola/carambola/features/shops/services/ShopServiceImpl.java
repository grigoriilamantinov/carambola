package com.lamantinov.carambola.carambola.features.shops.services;

import com.lamantinov.carambola.carambola.features.shops.dao.ShopRepository;
import com.lamantinov.carambola.carambola.features.shops.dto.ShopWithCarsDTO;
import com.lamantinov.carambola.carambola.features.shops.entity.Shop;
import com.lamantinov.carambola.carambola.features.shops.dto.ShopWithoutCarsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShopServiceImpl implements ShopService {

    private final ShopRepository shopRepository;

    public ShopServiceImpl(
        @Autowired final ShopRepository shopRepository
    ) {
        this.shopRepository = shopRepository;
    }

    @Override
    public List<Shop> getAll() {
        return shopRepository.findAll();
    }

    @Override
    public List<ShopWithoutCarsDTO> getAllWithoutCarsInfo() {
        return shopRepository.findAll().stream()
            .map(shop -> ShopWithoutCarsDTO.of(shop))
            .collect(Collectors.toList());
    }

    @Override
    public void save(final Shop shop) {
        shopRepository.save(shop);
    }

    @Override
    public Shop getById(final int shopId) {
        return shopRepository.getById(shopId);
    }

    @Override
    public ShopWithCarsDTO getCarsIntoShop(final int shopId) {
        final Shop shop = shopRepository.getById(shopId);
        return ShopWithCarsDTO.of(shop);
    }

    @Override
    public ShopWithoutCarsDTO getShopWithoutCarsById(final int shopId) {
        final Shop shop = shopRepository.getById(shopId);
        return ShopWithoutCarsDTO.of(shop);
    }

    @Override
    public void delete(final int shopId) {
        shopRepository.deleteById(shopId);
    }
    @Override
    public void deleteCarFromShop(int carId, int shopId) {
        var shop = this.getById(shopId);
        var cars = shop.getCars().stream()
            .filter(car -> car.getId() != carId)
            .collect(Collectors.toList());
        shop.setCars(cars);
        this.save(shop);
    }
}
