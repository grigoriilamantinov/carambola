package com.lamantinov.carambola.carambola.features.cars.controllers;

import com.lamantinov.carambola.carambola.features.cars.entity.Car;
import com.lamantinov.carambola.carambola.features.cars.services.CarService;
import com.lamantinov.carambola.carambola.features.cars.services.CarServiceImpl;
import com.lamantinov.carambola.carambola.features.shops.services.ShopService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/cars")
public class CarController {
    private final CarService carService;
    private final ShopService shopService;

    public CarController(
        CarService carService,
        ShopService shopService
    ) {
        this.carService = carService;
        this.shopService = shopService;
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

    @RequestMapping("/addNewCar")
    public String addNewCar(Model modelCar){
        Car car = new Car();
        modelCar.addAttribute("car", car);
        return "car-info";
    }

    @RequestMapping("/{id}/updateCar")
    public String updateCar(
        @PathVariable("id") int id,
        Model modelCar
    ){

        Car car = carService.getById(id);
        modelCar.addAttribute("car", car);
        return "car-info";
    }

    @PostMapping("/saveCar")
    public String saveCar(@ModelAttribute("car") Car car){

        if (car.getId()==0) {
            carService.save(car);
        } else {
            carService.updateCar(car);
        }
        return "redirect:/cars";
    }
}
