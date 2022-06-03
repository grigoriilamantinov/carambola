package com.lamantinov.carambola.carambola.features.shops.controllers;

import com.lamantinov.carambola.carambola.features.shops.dto.ShopWithCarsDTO;
import com.lamantinov.carambola.carambola.features.shops.entity.Shop;
import com.lamantinov.carambola.carambola.features.shops.dto.ShopWithoutCarsDTO;
import com.lamantinov.carambola.carambola.features.shops.services.ShopService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/shops/")
public class ApiShopController {

    private final ShopService shopService;

    public ApiShopController(
        final ShopService shopService
    ) {
        this.shopService = shopService;
    }

    @GetMapping()
    public List<ShopWithoutCarsDTO> showAllShops() {
        return shopService.getAllWithoutCarsInfo();
    }

    @GetMapping("/{id}")
    public ShopWithoutCarsDTO getShop(@PathVariable final int id) {
        return shopService.getShopWithoutCarsById(id);
    }

    @GetMapping("/{id}/cars")
    public ShopWithCarsDTO getShopWithCars(@PathVariable final int id) {
        return shopService.getCarsIntoShop(id);
    }

    @PostMapping()
    public int addNewShop(@RequestBody final Shop shop) {
        shopService.save(shop);
        return shop.getId();
    }

    @PutMapping()
    public String updateShop(@RequestBody final Shop shop) {
        shopService.save(shop);
        return "Shop " + shop.getId() + " was updated";
    }

    @DeleteMapping("/{id}")
    public String deleteShop(@PathVariable final int id) {
        shopService.delete(id);
        return "Shop with ID = " + id + " was deleted";
    }
}
