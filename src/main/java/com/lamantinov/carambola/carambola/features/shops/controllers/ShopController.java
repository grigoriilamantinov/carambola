package com.lamantinov.carambola.carambola.features.shops.controllers;

import com.lamantinov.carambola.carambola.features.cars.services.CarService;
import com.lamantinov.carambola.carambola.features.shops.services.ShopService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/shops")
public class ShopController {

    private final ShopService shopService;
    private final CarService carService;

    public ShopController(
        ShopService shopService,
        CarService carService
    ) {
        this.shopService = shopService;
        this.carService = carService;
    }

    @GetMapping()
    public String getShops(Model model) {
        model.addAttribute("shops", shopService.getAllWithoutCarsInfo());
        return "shops";
    }

    @GetMapping("/{id}/cars")
    public String showCars(@PathVariable("id") int id, Model modelCars, Model modelShop) {
        modelShop.addAttribute("modelShops", shopService.getById(id));
        modelCars.addAttribute("modelCars", shopService.getById(id).getCars());
        return "shops-cars";
    }

    @GetMapping("/{id}")
    public String showShops(@PathVariable("id") int id, Model model) {
        model.addAttribute("shop", shopService.getById(id));
        return "shop-id";
    }

    @DeleteMapping("/{shop_id}/car/{car_id}")
    public String deleteCarFromShop(
        @PathVariable("shop_id") int shopId,
        @PathVariable("car_id") int carId
    ){
        shopService.deleteCarFromShop(carId, shopId);
        return "redirect:/shops/{shop_id}/cars";
    }

    @PutMapping("/{shop_id}/add/{car_id}")
    public String addCarIntoShop(
        @PathVariable("shop_id") int shopId,
        @PathVariable("car_id") int carId
    ) {
        shopService.addCarIntoShop(carId, shopId);
        return "redirect:/shops/{shop_id}/addPage";
    }

    @GetMapping ("/{id}/addPage")
    public String showAddPage(
        @PathVariable("id") int shopId,
        Model modelCar,
        Model modelShop
    ){
        modelShop.addAttribute("modelShop", shopService.getById(shopId));
        modelCar.addAttribute("modelCar", shopService.getCarAvailableForAdd(shopId));
        return "add-car-to-shop";
    }


}
