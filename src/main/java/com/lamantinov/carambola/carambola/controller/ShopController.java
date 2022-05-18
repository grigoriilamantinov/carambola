package com.lamantinov.carambola.carambola.controller;

import com.lamantinov.carambola.carambola.dto.ShopWithCarsDTO;
import com.lamantinov.carambola.carambola.entity.Shop;
import com.lamantinov.carambola.carambola.dto.ShopWithoutCarsDTO;
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
    public List<ShopWithoutCarsDTO> showAllShops() {
        return shopService.getAllWithoutCarsInfo();
    }

    @GetMapping("/shops/{id}")
    public ShopWithoutCarsDTO getShop(@PathVariable int id) {
        return shopService.getShopWithoutCarsById(id);
    }

    @GetMapping("/shops/{id}/cars")
    public ShopWithCarsDTO getShopWithCars(@PathVariable int id) {
        return shopService.getCarsIntoShop(id);
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
