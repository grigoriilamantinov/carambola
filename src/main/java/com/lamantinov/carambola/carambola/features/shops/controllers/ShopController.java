package com.lamantinov.carambola.carambola.features.shops.controllers;

import com.lamantinov.carambola.carambola.features.shops.services.ShopService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/shops")
public class ShopController {

    private final ShopService shopService;

    public ShopController(
        final ShopService shopService
    ) {
        this.shopService = shopService;
    }

    @GetMapping()
    public String getShops(Model model) {
        model.addAttribute("shops", shopService.getAllWithoutCarsInfo());
        return "shops";
    }

    @GetMapping("/{id}/cars")
    public String showCars(@PathVariable("id") int id, Model model) {
        model.addAttribute("shop", shopService.getCarsIntoShop(id));
        return "shops/id/cars";
    }

}
