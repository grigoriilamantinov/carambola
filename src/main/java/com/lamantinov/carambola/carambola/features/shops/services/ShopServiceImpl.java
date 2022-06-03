package com.lamantinov.carambola.carambola.features.shops.services;

import com.lamantinov.carambola.carambola.features.cars.entity.Car;
import com.lamantinov.carambola.carambola.features.cars.services.CarService;
import com.lamantinov.carambola.carambola.features.shops.dao.ShopRepository;
import com.lamantinov.carambola.carambola.features.shops.dto.ShopWithCarsDTO;
import com.lamantinov.carambola.carambola.features.shops.entity.Shop;
import com.lamantinov.carambola.carambola.features.shops.dto.ShopWithoutCarsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShopServiceImpl implements ShopService {

    private final ShopRepository shopRepository;
    private final CarService carService;

    public ShopServiceImpl(
        @Autowired final ShopRepository shopRepository,
        @Autowired final CarService carService
    ) {
        this.shopRepository = shopRepository;
        this.carService = carService;
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
    public void addCarIntoShop(final int carId, final int shopId) {
        final var shop = this.getById(shopId);
        final var addableCar = carService.getById(carId);
        final var newCarsList = shop.getCars();
        newCarsList.add(addableCar);
        shop.setCars(newCarsList);
        this.save(shop);
    }

    @Override
    public void deleteCarFromShop(final int carId, final  int shopId) {
        final var shop = this.getById(shopId);
        final var cars = shop.getCars().stream()
            .filter(car -> car.getId() != carId)
            .collect(Collectors.toList());
        shop.setCars(cars);
        this.save(shop);
    }

    @Override
    public List<Car> getCarAvailableForAdd(final int shopId) {
        final var carsIds = shopRepository.getById(shopId).getCars().stream()
            .map(Car::getId)
            .collect(Collectors.toList());
        return carService.getAll().stream()
            .filter(car -> !carsIds.contains(car.getId()))
            .collect(Collectors.toList());
    }
}
