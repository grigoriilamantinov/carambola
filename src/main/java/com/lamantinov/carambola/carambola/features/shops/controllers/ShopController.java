package com.lamantinov.carambola.carambola.features.shops.controllers;

import com.lamantinov.carambola.carambola.features.shops.dto.ShopWithCarsDTO;
import com.lamantinov.carambola.carambola.features.shops.entity.Shop;
import com.lamantinov.carambola.carambola.features.shops.dto.ShopWithoutCarsDTO;
import com.lamantinov.carambola.carambola.features.shops.services.ShopService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class ShopController {

    private final ShopService shopService;

    public ShopController(
        final ShopService shopService
    ) {
        this.shopService = shopService;
    }

    @GetMapping("/shops")
    public List<ShopWithoutCarsDTO> showAllShops() {
        return shopService.getAllWithoutCarsInfo();
    }

    @GetMapping("/shops/{id}")
    public ShopWithoutCarsDTO getShop(@PathVariable final int id) {
        return shopService.getShopWithoutCarsById(id);
    }

    @GetMapping("/shops/{id}/cars")
    public ShopWithCarsDTO getShopWithCars(@PathVariable final int id) {
        return shopService.getCarsIntoShop(id);
    }

    @PostMapping("/shops")
    public Shop addNewShop(@RequestBody final Shop shop) {
        shopService.save(shop);
        return shop;
    }

    @PutMapping("/shops")
    public Shop updateShop(@RequestBody final Shop shop) {
        shopService.save(shop);
        return shop;
    }

    @DeleteMapping("/shops/{id}")
    public String deleteShop(@PathVariable final int id) {
        shopService.delete(id);
        return "Shop with ID = " + id + " was deleted";
    }
}
