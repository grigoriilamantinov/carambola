package com.lamantinov.carambola.carambola.features.cars.controllers;

import com.lamantinov.carambola.carambola.features.cars.entity.Car;
import com.lamantinov.carambola.carambola.features.cars.services.CarService;
import com.lamantinov.carambola.carambola.features.shops.services.ShopService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cars")
public class CarController {
    private final CarService carService;
    private final ShopService shopService;

    public CarController(
        final CarService carService,
        final ShopService shopService
    ) {
        this.carService = carService;
        this.shopService = shopService;
    }

    @GetMapping()
    public String getShops(final Model model) {
        model.addAttribute("cars", carService.getAllWithoutShopsInfo());
        return "cars";
    }

    @GetMapping("/{id}")
    public String showOneCar(@PathVariable("id") final int id, final Model modelCar){
        modelCar.addAttribute("car", carService.getById(id));
        return "car-id";
    }

    @RequestMapping("/addNewCar")
    public String addNewCar(final Model modelCar){
        Car car = new Car();
        modelCar.addAttribute("car", car);
        return "car-info";
    }

    @RequestMapping("/{id}/updateCar")
    public String updateCar(
        @PathVariable("id") final int id,
        final Model modelCar
    ){
        final Car car = carService.getById(id);
        modelCar.addAttribute("car", car);
        return "car-info";
    }

    @PostMapping("/saveCar")
    public String saveCar(@ModelAttribute("car") final Car car){
        if (car.getId() == 0) {
            carService.save(car);
        } else {
            carService.updateCar(car);
        }
        return "redirect:/shops/";
    }
}
