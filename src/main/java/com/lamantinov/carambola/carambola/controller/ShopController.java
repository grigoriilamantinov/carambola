package com.lamantinov.carambola.carambola.controller;

import com.lamantinov.carambola.carambola.entity.Shop;
import com.lamantinov.carambola.carambola.dto.ShopsWithoutCarsDTO;
import com.lamantinov.carambola.carambola.service.ShopService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class ShopController {

    private final ShopService shopService;

    public ShopController(
        ShopService shopService
    ) {
        this.shopService = shopService;
    }

    @GetMapping("/shops")
    public List<ShopsWithoutCarsDTO> showAllShops() {
        return shopService.getAllWithoutCarsInfo();
    }

    @GetMapping("/shops/{id}")
    public Shop getShop(@PathVariable int id) {
        Shop shop = shopService.getById(id);
        return shop;
    }

    @PostMapping("/shops")
    public Shop addNewShop(@RequestBody Shop shop) {
        shopService.save(shop);
        return shop;
    }

    @PutMapping("/shops")
    public Shop updateShop(@RequestBody Shop shop) {
        shopService.save(shop);
        return shop;
    }

    @DeleteMapping("/shops/{id}")
    public String deleteShop(@PathVariable int id) {
        shopService.delete(id);
        return "Shop with ID = " + id + " was deleted";
    }
}
