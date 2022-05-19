package com.lamantinov.carambola.carambola.service;

import com.lamantinov.carambola.carambola.dao.ShopRepository;
import com.lamantinov.carambola.carambola.dto.ShopWithCarsDTO;
import com.lamantinov.carambola.carambola.entity.Shop;
import com.lamantinov.carambola.carambola.dto.ShopWithoutCarsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShopService implements ServiceInterface <Shop> {

    private final ShopRepository shopRepository;

    public ShopService(
        @Autowired ShopRepository shopRepository
    ) {
        this.shopRepository = shopRepository;
    }

    @Override
    public List<Shop> getAll() {
        return shopRepository.findAll();
    }

    public List<ShopWithoutCarsDTO> getAllWithoutCarsInfo() {
        return shopRepository.findAll().stream()
            .map(shop -> ShopWithoutCarsDTO.of(shop))
            .collect(Collectors.toList());
    }

    @Override
    public void save(Shop shop) {
        shopRepository.save(shop);
    }

    @Override
    public Shop getById(int shopId) {
        return shopRepository.getById(shopId);
    }

    public ShopWithCarsDTO getCarsIntoShop(int shopId) {
        Shop shop = shopRepository.getById(shopId);
        return ShopWithCarsDTO.of(shop);
    }

    public ShopWithoutCarsDTO getShopWithoutCarsById(int shopId) {
        Shop shop = shopRepository.getById(shopId);
        return ShopWithoutCarsDTO.of(shop);
    }

    @Override
    public void delete(int shopId) {
        shopRepository.deleteById(shopId);
    }
}
