package com.lamantinov.carambola.carambola.features.cars.controllers;

import com.lamantinov.carambola.carambola.features.cars.dto.CarIntoShopsDTO;
import com.lamantinov.carambola.carambola.features.cars.dto.CarWithoutShopsDTO;
import com.lamantinov.carambola.carambola.features.cars.entity.Car;
import com.lamantinov.carambola.carambola.features.cars.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cars/")
public class CarController {

    private final CarService carService;

    public CarController(
        @Autowired final CarService carService
    ) {
        this.carService = carService;
    }

    @GetMapping()
    public List<CarWithoutShopsDTO> showAllCars() {
        return carService.getAllWithoutShopsInfo();
    }

    @GetMapping("/{id}")
    public CarWithoutShopsDTO getCar(@PathVariable final int id) {
        return carService.getCarsWithoutShopsById(id);
    }

    @GetMapping("/{id}/shops")
    public CarIntoShopsDTO getCarIntoAllShops(@PathVariable final int id) {
        return carService.getCarIntoShops(id);
    }
  
    @PostMapping()
    public int addNewCar(@RequestBody final Car car) {
        carService.save(car);
        return car.getId();
    }
  
    @PutMapping()
    public String updateCar(@RequestBody final Car car) {
        carService.save(car);
        return "Car " + car.getId() + " was updated";
    }

    @DeleteMapping("/{id}")
    public String deleteCar(@PathVariable final int id) {
        carService.delete(id);
        return "Car with ID = " + id + " was deleted";
    }
}
