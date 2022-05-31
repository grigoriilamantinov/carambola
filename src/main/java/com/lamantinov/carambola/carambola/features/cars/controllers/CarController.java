package com.lamantinov.carambola.carambola.features.cars.controllers;

import com.lamantinov.carambola.carambola.features.cars.services.CarService;
import com.lamantinov.carambola.carambola.features.shops.services.ShopService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cars")
public class CarController {
    private final CarService carService;

    public CarController(
        final CarService carService
    ) {
        this.carService = carService;
    }

    @GetMapping()
    public String getShops(Model model) {
        model.addAttribute("cars", carService.getAllWithoutShopsInfo());
        return "cars";
    }

    @GetMapping("/{id}")
    public String showOneCar(@PathVariable("id") int id, Model modelCar){
        modelCar.addAttribute("car", carService.getById(id));
        return "carId";
    }
}
